package com.lmc.shopleasing.service.impl;

import com.lmc.shopleasing.core.AbstractService;
import com.lmc.shopleasing.dao.SysAreaMapper;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.entity.SysMenu;
import com.lmc.shopleasing.service.SysAreaService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by lmc on 2019/11/07.
 */
@Service
@Transactional
public class SysAreaServiceImpl extends AbstractService<SysArea> implements SysAreaService {

    @Resource
    private SysAreaMapper sysAreaMapper;

    @Override
    public List<SysArea> findRoots() {
        Condition condition = new Condition(SysArea.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andIsNull("parentId");
        condition.orderBy("order").asc();
        return  sysAreaMapper.selectByCondition(condition);
    }

    @Override
    public List<SysArea> findParents(SysArea sysArea, boolean recursive) {
        if(sysArea == null || sysArea.getParentId() == null){
            return Collections.emptyList();
        }
        Condition condition = new Condition(SysArea.class);
        Example.Criteria criteria = condition.createCriteria();
        if(recursive){
            criteria.andIn("parentId", Arrays.asList(sysArea.getParentIds()));
            condition.orderBy("grade").asc();
        }else {
            criteria.andEqualTo("parentId",sysArea.getParentId());
        }
        return sysAreaMapper.selectByCondition(condition);
    }

    @Override
    public List<SysArea> findChildren(SysArea sysArea, boolean recursive) {
        Condition condition = new Condition(SysMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        if (recursive) {
            if (sysArea != null) {
                criteria.andLike("treePath","%" + SysMenu.TREE_PATH_SEPARATOR + sysArea.getId() + SysMenu.TREE_PATH_SEPARATOR + "%");
            }
            condition.orderBy("grade").asc().orderBy("order").asc();
            List<SysArea> result = sysAreaMapper.selectByCondition(condition);
            sort(result);
            return result;
        } else {
            criteria.andEqualTo("parentId",sysArea.getId());
            condition.orderBy("order").asc();
            return sysAreaMapper.selectByCondition(condition);
        }
    }

    /**
     * 排序区域
     *
     */
    private void sort(List<SysArea> sysAreas) {
        if (CollectionUtils.isEmpty(sysAreas)) {
            return;
        }
        final Map<Integer, Integer> orderMap = new HashMap<>();
        for (SysArea sysArea : sysAreas) {
            orderMap.put(sysArea.getId(), sysArea.getOrder());
        }
        Collections.sort(sysAreas, new Comparator<SysArea>() {
            @Override
            public int compare(SysArea sysAreas1, SysArea sysAreas2) {
                Integer[] ids1 = (Integer[]) ArrayUtils.add(sysAreas1.getParentIds(),sysAreas1.getId());
                Integer[] ids2 = (Integer[]) ArrayUtils.add(sysAreas1.getParentIds(), sysAreas1.getId());
                Iterator<Integer> iterator1 = Arrays.asList(ids1).iterator();
                Iterator<Integer> iterator2 = Arrays.asList(ids2).iterator();
                CompareToBuilder compareToBuilder = new CompareToBuilder();
                while (iterator1.hasNext() && iterator2.hasNext()) {
                    Integer id1 = iterator1.next();
                    Integer id2 = iterator2.next();
                    Integer order1 = orderMap.get(id1);
                    Integer order2 = orderMap.get(id2);
                    compareToBuilder.append(order1, order2).append(id1, id2);
                    if (!iterator1.hasNext() || !iterator2.hasNext()) {
                        compareToBuilder.append(sysAreas1.getGrade(), sysAreas1.getGrade());
                    }
                }
                return compareToBuilder.toComparison();
            }
        });
    }

    /**
     * 递归上级地区
     *
     * @param parents
     *            上级地区
     * @param sysArea
     *            地区
     */
    private void recursiveParents(List<SysArea> parents, SysArea sysArea) {
        if (sysArea == null) {
            return;
        }
        SysArea parent = sysArea.getParent();
        if (parent != null) {
            parents.add(0, parent);
            recursiveParents(parents, parent);
        }
    }

}
