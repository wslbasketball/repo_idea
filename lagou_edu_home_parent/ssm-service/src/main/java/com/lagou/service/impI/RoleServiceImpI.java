package com.lagou.service.impI;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/5 19:27
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class RoleServiceImpI implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    //1.根据角色名称查询角色列表信息
    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    //2.根据角色ID查询角色所关联的菜单信息
    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleId);
        return menuByRoleId;
    }

    //3.为角色分配菜单信息
    @Override
    public void roleContextMenu(RoleMenuVO roleMenuVO) {
        //1.清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVO.getRoleId());

        //2.为角色分配菜单
        List<Integer> menuIdList = roleMenuVO.getMenuIdList();
        for (Integer mid : menuIdList) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVO.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");

            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    //4.删除角色
    @Override
    public void deleteRole(Integer id) {
        //先清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(id);

        roleMapper.deleteRole(id);
    }

    //5.添加角色
    @Override
    public void saveRole(Role role) {
        //封装数据
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);

        role.setCreatedBy("王某某");
        role.setUpdatedBy("王某某");

        roleMapper.saveRole(role);
    }

    //6.根据roleId回显角色信息
    @Override
    public Role findRoleById(Integer id) {
        Role role = roleMapper.findRoleById(id);
        return role;
    }

    //7.更新角色
    @Override
    public void updateRole(Role role) {
        //封装数据
        role.setUpdatedTime(new Date());
        role.setUpdatedBy("张某某");

        roleMapper.updateRole(role);
    }

    //8.根据角色id查询角色所关联的资源信息
    @Override
    public List<ResourceCategory> findResourceCategoryListByRoleId(Integer roleId) {
        //获取资源信息
        List<Resource> resourceList = roleMapper.findResourceListByRoleId(roleId);
        //获取资源分类信息
        List<ResourceCategory> resourceCategoryList = roleMapper.findResourceCategoryListByRoleId(roleId);
        for (ResourceCategory resourceCategory : resourceCategoryList) {
            resourceCategory.setResourceList(resourceList);
        }
        return resourceCategoryList;
    }

    //9.为角色分配资源信息
    @Override
    public void roleContextResource(RoleResourceVO roleResourceVO) {
        //1.清空中间表的关联关系
        roleMapper.deleteRoleContextResource(roleResourceVO.getRoleId());

        //2.为角色分配资源
        List<Integer> resourceIdList = roleResourceVO.getResourceIdList();
        for (Integer rid : resourceIdList) {
            Role_resource_relation role_resource_relation = new Role_resource_relation();
            role_resource_relation.setResourceId(rid);
            role_resource_relation.setRoleId(roleResourceVO.getRoleId());

            //封装数据
            Date date = new Date();
            role_resource_relation.setCreatedTime(date);
            role_resource_relation.setUpdatedTime(date);

            role_resource_relation.setCreatedBy("system");
            role_resource_relation.setUpdatedBy("system");

            roleMapper.roleContextResource(role_resource_relation);
        }
    }



}
