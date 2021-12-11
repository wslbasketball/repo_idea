package com.lagou.service;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.domain.RoleResourceVO;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/5 19:26
 * @Project_Name lagou_edu_home_parent
 */
public interface RoleService {

    /**
     * 1.根据角色名称查询角色列表信息
     */
    public List<Role> findAllRole(Role role);

    /**
     * 2.根据角色ID查询角色所关联的菜单信息
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /**
     * 3.为角色分配菜单信息
     */
    public void roleContextMenu(RoleMenuVO roleMenuVO);

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
     * 8.根据角色id查询角色所关联的资源信息
     */
     public List<ResourceCategory> findResourceCategoryListByRoleId(Integer roleId);

    /**
     * 9.为角色分配资源信息
     */
    public void roleContextResource(RoleResourceVO roleResourceVO);

}
