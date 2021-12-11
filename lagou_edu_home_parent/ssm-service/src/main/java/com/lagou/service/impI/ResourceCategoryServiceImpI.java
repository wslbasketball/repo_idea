package com.lagou.service.impI;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.domain.ResourceCategory;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/6 21:22
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class ResourceCategoryServiceImpI implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    //1.查询所有资源分类信息
    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();
        return allResourceCategory;
    }

    //2.新增资源分类
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        //封装数据
        Date date = new Date();
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);

        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");

        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    //3.根据id回显资源分类信息
    @Override
    public ResourceCategory findResourceCategoryById(Integer id) {
        ResourceCategory resourceCategoryById = resourceCategoryMapper.findResourceCategoryById(id);
        return resourceCategoryById;
    }

    //4.更新资源分类
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
        //封装数据
        resourceCategory.setUpdatedTime(new Date());

        resourceCategory.setUpdatedBy("system");

        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    //5.删除资源分类
    @Override
    public void deleteResourceCategory(Integer id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }


}
