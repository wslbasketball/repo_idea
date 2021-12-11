package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/4 22:00
 * @Project_Name lagou_edu_home_parent
 */
public interface UserMapper {

    /**
     * 1.用户分页查询&多条件组合查询
     */
    public List<User> findAllUserByPage(UserVO userVO);

    /**
     * 2.更新用户状态
     */
    public void updateUserStatus(User user);

    /**
     * 3.用户登录（根据用户名查询具体的用户信息）
     */
    public User login(User user);

    /**
     * 4.测试用户注册（加密）
     */
    public void register(User user);

    /**
     * 6.1 根据用户id清空中间表（User_Role_relation）
     */
    public void deleteUserContextRole(Integer userId);

    /**
     * 6.2 分配角色
     */
    public void userContextRole(User_Role_relation user_role_relation);

    /**
     * 5.根据用户id查询所关联的当前角色信息(回显)
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /**
     * 5和7都用于动态获取菜单
     *
     * 7.1 根据角色ID，查询角色所拥有的顶级菜单(-1)
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /**
     * 7.2 根据PID，查询父菜单所关联的子菜单信息
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /**
     * 7.3 获取用户拥有的资源权限信息
     */
    public List<Resource> findResourceByRoleId(List<Integer> ids);

}
