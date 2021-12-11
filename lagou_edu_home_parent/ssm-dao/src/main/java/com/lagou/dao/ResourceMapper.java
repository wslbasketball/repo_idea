package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/6 20:52
 * @Project_Name lagou_edu_home_parent
 */
public interface ResourceMapper {

    /**
     * 1.资源信息分页&多条件查询
     */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);

    /**
     * 2.新增资源
     */
    public void saveResource(Resource resource);

    /**
     * 3.根据id回显资源信息
     */
    public Resource findResourceById(Integer id);

    /**
     * 4.更新资源
     */
    public void updateResource(Resource resource);

    /**
     * 5.删除资源
     */
    public void deleteResource(Integer id);
}
