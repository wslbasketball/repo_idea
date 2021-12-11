package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/5 19:22
 * @Project_Name lagou_edu_home_parent
 */
public interface RoleMapper {

    /**
     * 1.根据角色名称查询角色列表信息
     */
    public List<Role> findAllRole(Role role);

    /**
     * 2.根据角色ID查询角色所关联的菜单信息
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /**
     * 3.1 根据roleId来清空中间表的关联关系（role_menu_relation）
     */
    public void deleteRoleContextMenu(Integer rid);

    /**
     * 3.2 为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /**
     * 4.删除角色
     */
    public void deleteRole(Integer id);

    /**
     * 5.添加角色
     */
    public void saveRole(Role role);

    /**
     * 6.根据roleId回显角色信息
     */
    public Role findRoleById(Integer id);

    /**
     * 7.更新角色
     */
    public void updateRole(Role role);

    /**
     * 8.1 根据角色id查询角色所关联的资源分类信息
     */
    public List<ResourceCategory> findResourceCategoryListByRoleId(Integer roleId);

    /**
     * 8.2 根据角色id查询角色所关联的资源信息
     */
    public List<Resource> findResourceListByRoleId(Integer roleId);

    /**
     * 9.1 根据roleId清空中间表的关联关系（role_resource_relation）
     */
    public void deleteRoleContextResource(Integer rid);

    /**
     * 9.2 为角色分配资源信息
     */
    public void roleContextResource(Role_resource_relation role_resource_relation);
}
