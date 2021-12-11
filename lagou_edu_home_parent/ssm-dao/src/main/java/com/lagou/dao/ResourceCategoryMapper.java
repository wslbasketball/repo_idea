package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/6 21:18
 * @Project_Name lagou_edu_home_parent
 */
public interface ResourceCategoryMapper {

    /**
     * 1.查询所有资源分类信息
     */
    public List<ResourceCategory> findAllResourceCategory();

    /**
     * 2.新增资源分类
     */
    public void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 3.根据id回显资源分类信息
     */
    public ResourceCategory findResourceCategoryById(Integer id);

    /**
     * 4.更新资源分类
     */
    public void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 5.删除资源分类
     */
    public void deleteResourceCategory(Integer id);
}
