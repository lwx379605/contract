package com.lmc.shopleasing.service.impl;

import com.google.common.collect.Lists;
import com.lmc.shopleasing.core.AbstractService;
import com.lmc.shopleasing.dao.SysUserMapper;
import com.lmc.shopleasing.dao.SysUserRoleMapper;
import com.lmc.shopleasing.entity.CustomUserDetails;
import com.lmc.shopleasing.entity.SysRole;
import com.lmc.shopleasing.entity.SysUser;
import com.lmc.shopleasing.entity.SysUserRole;
import com.lmc.shopleasing.service.SysUserService;
import com.lmc.shopleasing.util.SpringUtils;
import com.lmc.shopleasing.util.SysUserHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by lmc on 2019/11/02.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {

    protected final Log logger = LogFactory.getLog(getClass());

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired(required = true)
    private UserCache userCache;

    @Override
    public int updatePassword(@NotEmpty String loginName, @NotEmpty String password) {
        return sysUserMapper.updatePassword(loginName,password);
    }

    /**
     * 认证过程中 - 根据登录信息获取用户详细信息
     *
     * @param userName 登录用户输入的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails user = this.userCache.getUserFromCache(userName);
        if(user != null){
            return user;
        }
        //根据用户输入的用户信息，查询数据库中已注册用户信息
        SysUser sysUser = findBy("loginName", userName);
        //如果用户不存在直接抛出UsernameNotFoundException异常
        if(sysUser==null){
            throw new UsernameNotFoundException("登录账号为"+userName+"的用户不存在");
        }
        CustomUserDetails userDetails = new CustomUserDetails(sysUser);
        //TODO
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(StringUtils.equals(userName,"lmc")){
            authorities.add(new SimpleGrantedAuthority("abc"));
        }else if(StringUtils.equals(userName,"fd")){
            authorities.add(new SimpleGrantedAuthority("sudo"));
        }else {
            authorities.add(new SimpleGrantedAuthority("other"));
        }


        userDetails.setAuthorities(authorities);
        this.userCache.putUserInCache(userDetails);
        return userDetails;
    }

    @Override
    public void createUser(UserDetails userDetails) {
        Assert.isInstanceOf(SysUser.class, userDetails);
        Assert.hasText(userDetails.getPassword(),"密码不能为空");
        SysUser user = (SysUser)userDetails;
        Assert.notEmpty(user.getSysRoles(),"用户角色不能为空");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        SysUser current = SysUserHolder.getUserDetail();
        user.setCreateBy(current.getId()+"");
        user.setCreatedDate(new Date());
        user.setDelFlag(false);
        save(user);
        List<SysUserRole> sysUserRoleList = Lists.newArrayList();
        for(SysRole userRole:user.getSysRoles()){
            sysUserRoleList.add(new SysUserRole(userRole.getId(),user.getId()));
        }
        sysUserRoleMapper.insertList(sysUserRoleList);
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        Assert.isInstanceOf(SysUser.class, userDetails);
        SysUser user = (SysUser)userDetails;
        Assert.notNull(user.getId(),"用户ID不能为空");
        Assert.notEmpty(user.getSysRoles(),"用户角色不能为空");
        user.setPassword(null);
        user.setLoginName(null);
        update(user);
        Condition condition =new Condition(SysUserRole.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId",user.getId());
        sysUserRoleMapper.deleteByCondition(condition);
        List<SysUserRole> sysUserRoleList = Lists.newArrayList();
        for(SysRole userRole:user.getSysRoles()){
            sysUserRoleList.add(new SysUserRole(userRole.getId(),user.getId()));
        }
        sysUserRoleMapper.insertList(sysUserRoleList);
        userCache.removeUserFromCache(user.getLoginName());
    }

    @Override
    public void deleteUser(String username) {
        SysUser user = findBy("loginName", username);
        deleteById(user.getId());
        Condition condition =new Condition(SysUserRole.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId",user.getId());
        sysUserRoleMapper.deleteByCondition(condition);
        userCache.removeUserFromCache(username);
    }

    public void delete(Integer id) {
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        deleteById(user.getId());
        Condition condition =new Condition(SysUserRole.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId",user.getId());
        sysUserRoleMapper.deleteByCondition(condition);
        userCache.removeUserFromCache(user.getLoginName());
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext()
                .getAuthentication();

        if (currentUser == null) {
            // This would indicate bad coding somewhere
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context "
                            + "for current user.");
        }

        String username = currentUser.getName();

        // If an authentication manager has been set, re-authenticate the user with the
        // supplied password.
        AuthenticationManager authenticationManager = SpringUtils.getBean(AuthenticationManager.class);
        if (authenticationManager != null) {
            logger.debug("Reauthenticating user '" + username
                    + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    username, oldPassword));
        }
        else {
            logger.debug("No authentication manager set. Password won't be re-checked.");
        }

        logger.debug("Changing password for user '" + username + "'");
        newPassword = passwordEncoder.encode(newPassword);
        updatePassword(username, newPassword);

        SecurityContextHolder.getContext().setAuthentication(
                createNewAuthentication(currentUser, newPassword));

        userCache.removeUserFromCache(username);
    }

    protected Authentication createNewAuthentication(Authentication currentAuth,
                                                     String newPassword) {
        UserDetails user = loadUserByUsername(currentAuth.getName());

        UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());
        newAuthentication.setDetails(currentAuth.getDetails());

        return newAuthentication;
    }

    @Override
    public boolean userExists(String username) {
        try{
            SysUser users = findBy("loginName", username);
            return users!= null;
        }catch (Exception e){
            throw new IncorrectResultSizeDataAccessException(
                    "More than one user found with name '" + username + "'", 1);
        }
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        List<SysUser> sysUsers = findByIds(StringUtils.join(ids, ","));
        for(SysUser sysUser:sysUsers){
            deleteById(sysUser.getId());
            Condition condition =new Condition(SysUserRole.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("userId",sysUser.getId());
            sysUserRoleMapper.deleteByCondition(condition);
        }
        for(SysUser sysUser:sysUsers){
            userCache.removeUserFromCache(sysUser.getLoginName());
        }
    }
}
