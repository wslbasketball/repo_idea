package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/4 22:16
 * @Project_Name lagou_edu_home_parent
 */
public interface UserService {

    /**
     * 1.用户分页查询&多条件组合查询
     */
    public PageInfo findAllUserByPage(UserVO userVO);

    /**
     * 2.更新用户状态
     */
    public void updateUserStatus(int id,String status);

    /**
     * 3.用户登录（根据用户名查询具体的用户信息）
     */
    public User login(User user) throws Exception;

     /**
     * 4.测试用户注册（加密）
     */
    public void register(User user) throws Exception;

    /**
     * 5.根据用户id查询所关联的当前角色信息(回显)
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /**
     * 6.分配角色
     */
    public void userContextRole(UserVO userVO);

    /**
     * 7.获取用户权限，进行菜单动态展示
     */
    public ResponseResult getUserPermissions(Integer userId);
}
