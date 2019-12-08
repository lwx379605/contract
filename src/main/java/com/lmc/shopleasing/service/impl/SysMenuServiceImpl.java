package com.lmc.shopleasing.service.impl;

import com.google.common.collect.Lists;
import com.lmc.shopleasing.dao.SysMenuMapper;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.entity.SysMenu;
import com.lmc.shopleasing.entity.SysUser;
import com.lmc.shopleasing.service.SysMenuService;
import com.lmc.shopleasing.core.AbstractService;
import com.lmc.shopleasing.util.SysUserHolder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by lmc on 2019/11/02.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findRoots() {
        Condition condition = new Condition(SysMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andIsNull("parentId");
        condition.orderBy("order").asc();
        return  sysMenuMapper.selectByCondition(condition);
    }

    @Override
    public List<SysMenu> findParents(SysMenu sysMenu, boolean recursive) {
        if(sysMenu == null || sysMenu.getParentId() == null){
            return Collections.emptyList();
        }
        Condition condition = new Condition(SysMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        if(recursive){
            criteria.andIn("parentId", Arrays.asList(sysMenu.getParentIds()));
            condition.orderBy("grade").asc();
        }else {
            criteria.andEqualTo("parentId",sysMenu.getParentId());
        }
        return sysMenuMapper.selectByCondition(condition);
    }

    @Override
    public List<SysMenu> findChildren(SysMenu sysMenu, boolean recursive) {
        Condition condition = new Condition(SysMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        if (recursive) {
            if (sysMenu != null) {
                criteria.andLike("treePath","%" + SysMenu.TREE_PATH_SEPARATOR + sysMenu.getId() + SysMenu.TREE_PATH_SEPARATOR + "%");
            }
            condition.orderBy("grade").asc().orderBy("order").asc();
            List<SysMenu> result = sysMenuMapper.selectByCondition(condition);
            sort(result);
            return result;
        } else {
            criteria.andEqualTo("parentId",sysMenu.getId());
            condition.orderBy("order").asc();
            return sysMenuMapper.selectByCondition(condition);
        }
    }

    @Override
    public List<SysMenu> findByUserName(String username,Boolean showHidden) {
        if(username==null){
            return Collections.emptyList();
        }
        List<SysMenu> sysMenuList = sysMenuMapper.findByLoginName(username);
        List<Integer> excludes= new ArrayList<>();

        CollectionUtils.filter(sysMenuList, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                SysMenu sysMenu = (SysMenu)object;
                if(!showHidden && StringUtils.equals(sysMenu.getIsShow(),"0") ){
                    excludes.add(sysMenu.getId());
//                    System.out.println("hidden  -->  "+sysMenu.getId());
                    return false;
                }
                if(StringUtils.equals(sysMenu.getIsShow(),"0") || StringUtils.equals(sysMenu.getDelFlag(),"1")){
                    excludes.add(sysMenu.getId());
//                    System.out.println("delete  -->  "+sysMenu.getId());
                    return false;
                }
                return true;
            }
        });
        if(excludes.size()>0){
            CollectionUtils.filter(sysMenuList, new Predicate() {
                @Override
                public boolean evaluate(Object object) {
                    SysMenu sysMenu = (SysMenu)object;
                    List<Integer> parentIds = Arrays.asList(sysMenu.getParentIds());
                    if(CollectionUtils.intersection(excludes,parentIds).isEmpty()){
                        return true;
                    }
//                    System.out.println("filter  --- > " + sysMenu.getId());
                    return false;
                }
            });
        }
        sort(sysMenuList);
        return sysMenuList;
    }

    @Override
    public List<SysMenu> findByUser(Boolean showHidden) {
        SysUser userDetail = SysUserHolder.getUserDetail();
        if(userDetail==null || userDetail.getLoginName()==null){
            return Collections.emptyList();
        }
        List<SysMenu> sysMenuList = sysMenuMapper.findByLoginName(userDetail.getLoginName());
        List<Integer> excludes= new ArrayList<>();

        CollectionUtils.filter(sysMenuList, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                SysMenu sysMenu = (SysMenu)object;
                if(!showHidden && StringUtils.equals(sysMenu.getIsShow(),"0") ){
                    excludes.add(sysMenu.getId());
//                    System.out.println("hidden  -->  "+sysMenu.getId());
                    return false;
                }
                if(StringUtils.equals(sysMenu.getIsShow(),"0") || StringUtils.equals(sysMenu.getDelFlag(),"1")){
                    excludes.add(sysMenu.getId());
//                    System.out.println("delete  -->  "+sysMenu.getId());
                   return false;
                }
                return true;
            }
        });
        if(excludes.size()>0){
            CollectionUtils.filter(sysMenuList, new Predicate() {
                @Override
                public boolean evaluate(Object object) {
                    SysMenu sysMenu = (SysMenu)object;
                    List<Integer> parentIds = Arrays.asList(sysMenu.getParentIds());
                    if(CollectionUtils.intersection(excludes,parentIds).isEmpty()){
                        return true;
                    }
//                    System.out.println("filter  --- > " + sysMenu.getId());
                    return false;
                }
            });
        }
        sort(sysMenuList);
        return sysMenuList;
    }

    /**
     * 排序菜单
     *
     * @param sysMenus
     *            菜单
     */
    private void sort(List<SysMenu> sysMenus) {
        if (CollectionUtils.isEmpty(sysMenus)) {
            return;
        }
        final Map<Integer, Integer> orderMap = new HashMap<>();
        for (SysMenu sysMenu : sysMenus) {
            orderMap.put(sysMenu.getId(), sysMenu.getOrder());
        }
        Collections.sort(sysMenus, new Comparator<SysMenu>() {
            @Override
            public int compare(SysMenu sysMenus1, SysMenu sysMenus2) {
                Integer[] ids1 = (Integer[]) ArrayUtils.add(sysMenus1.getParentIds(),sysMenus1.getId());
                Integer[] ids2 = (Integer[]) ArrayUtils.add(sysMenus2.getParentIds(), sysMenus2.getId());
                Iterator<Integer> iterator1 = Arrays.asList(ids1).iterator();
                Iterator<Integer> iterator2 = Arrays.asList(ids2).iterator();
                CompareToBuilder compareToBuilder = new CompareToBuilder();
//                StringBuilder ab= new StringBuilder();
//                StringBuilder ac= new StringBuilder();
                while (iterator1.hasNext() && iterator2.hasNext()) {
                    Integer id1 = iterator1.next();
                    Integer id2 = iterator2.next();
                    Integer order1 = orderMap.get(id1);
                    Integer order2 = orderMap.get(id2);
                    compareToBuilder.append(order1, order2).append(id1, id2);
//                    ab.append("order1="+order1).append("---").append("id1="+id1).append("---");
//                    ac.append("order2="+order2).append("---").append("id2="+id2).append("---");
                    if (!iterator1.hasNext() || !iterator2.hasNext()) {
                        compareToBuilder.append(sysMenus1.getGrade(), sysMenus2.getGrade());
//                        ab.append("Grade1="+sysMenus1.getGrade());
//                        ac.append("Grade2="+sysMenus2.getGrade());
                    }
                }
//                System.out.print(ab.toString());
//                System.out.print("----------->");
//                System.out.println(ac.toString());
                return compareToBuilder.toComparison();
            }
        });
    }

    /**
     * 递归上级菜单
     *
     * @param parents
     *            上级菜单
     * @param sysMenu
     *            菜单
     */
    private void recursiveParents(List<SysMenu> parents, SysMenu sysMenu) {
        if (sysMenu == null) {
            return;
        }
        SysMenu parent = sysMenu.getParent();
        if (parent != null) {
            parents.add(0, parent);
            recursiveParents(parents, parent);
        }
    }

}
