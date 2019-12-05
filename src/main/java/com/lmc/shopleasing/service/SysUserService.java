package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.SysUser;
import com.lmc.shopleasing.core.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.validation.constraints.NotEmpty;


/**
 * Created by lmc on 2019/11/02.
 */

public interface SysUserService extends Service<SysUser> ,UserDetailsManager {

    int  updatePassword(@NotEmpty String loginName, @NotEmpty String password);

    void deleteByIds(Integer[] ids);
}
