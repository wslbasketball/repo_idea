package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wsl
 * @Date 2021/12/6 21:05
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    //1.资源信息分页&多条件查询
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO){

        PageInfo<Resource> allResourceByPage = resourceService.findAllResourceByPage(resourceVO);

        return new ResponseResult(true,200,"资源分页以及多条件查询成功",allResourceByPage);
    }

    //2.新增&修改资源
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource){

        //判断是否携带id
        if (resource.getId() == null){
            //新增操作
            resourceService.saveResource(resource);
            return new ResponseResult(true,200,"新增资源信息成功", null);
        } else {
            //修改操作
            resourceService.updateResource(resource);
            return new ResponseResult(true,200,"更新资源信息成功", null);
        }
    }

    //3.根据id回显资源信息
    @RequestMapping("/findResourceById")
    public ResponseResult findResourceById(Integer id){

        Resource resource = resourceService.findResourceById(id);

        return new ResponseResult(true,200,"根据id回显资源信息成功", resource);
    }

    //4.删除资源
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id){

        resourceService.deleteResource(id);

        return new ResponseResult(true,200,"删除资源信息成功", null);
    }


}
