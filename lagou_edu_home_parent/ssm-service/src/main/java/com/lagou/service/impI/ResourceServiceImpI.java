package com.lagou.service.impI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/6 21:03
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class ResourceServiceImpI implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    //1.资源信息分页&多条件查询
    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO) {

        //分页查询
        PageHelper.startPage(resourceVO.getCurrentPage(),resourceVO.getPageSize());
        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourceVO);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);
        return pageInfo;
    }

    //2.新增资源
    @Override
    public void saveResource(Resource resource) {
        //封装数据
        Date date = new Date();
        resource.setCreatedTime(date);
        resource.setUpdatedTime(date);

        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");

        resourceMapper.saveResource(resource);
    }

    //3.根据id回显资源信息
    @Override
    public Resource findResourceById(Integer id) {
        Resource resource = resourceMapper.findResourceById(id);
        return resource;
    }

    //4.更新资源
    @Override
    public void updateResource(Resource resource) {
        //封装数据
        resource.setUpdatedTime(new Date());

        resource.setUpdatedBy("system");

        resourceMapper.updateResource(resource);
    }

    //5.删除资源
    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }

}
