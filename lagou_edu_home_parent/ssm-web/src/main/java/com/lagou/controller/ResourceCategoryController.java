package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/6 21:24
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    //1.查询所有资源分类信息
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){

        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return new ResponseResult(true,200,"查询资源分类列表信息成功",allResourceCategory);
    }

    //2.新增&修改资源分类
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){

        //判断是否携带id
        if (resourceCategory.getId() == null){
            //新增操作
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return new ResponseResult(true,200,"新增资源分类信息成功",null);
        } else {
            //修改操作
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return new ResponseResult(true,200,"更新资源分类信息成功",null);
        }

    }

    //3.根据id回显资源分类信息
    @RequestMapping("/findResourceCategoryById")
    public ResponseResult findResourceCategoryById(Integer id){

        ResourceCategory resourceCategory = resourceCategoryService.findResourceCategoryById(id);

        return new ResponseResult(true,200,"根据id回显资源分类信息成功",resourceCategory);
    }

    //4.删除资源分类
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){

        resourceCategoryService.deleteResourceCategory(id);

        return new ResponseResult(true,200,"删除资源分类信息成功",null);
    }
}
