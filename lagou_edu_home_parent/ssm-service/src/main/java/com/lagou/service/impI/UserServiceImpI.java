package com.lagou.service.impI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author wsl
 * @Date 2021/12/4 22:17
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class UserServiceImpI implements UserService {

    @Autowired
    private UserMapper userMapper;

    //1.用户分页查询&多条件组合查询
    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {

        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVO);

        PageInfo<User> pageInfo = new PageInfo<>(allUserByPage);
        return pageInfo;
    }

    //2.更新用户状态
    @Override
    public void updateUserStatus(int id, String status) {
        //封装数据
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdate_time(new Date());

        //调用Mapper方法
        userMapper.updateUserStatus(user);
    }

    //3.用户登录（根据用户名查询具体的用户信息）
    @Override
    public User login(User user) throws Exception {

        //调用Mapper方法
        User user2 = userMapper.login(user);

        //判断user2是否为空
        if (user2 != null && Md5.verify(user.getPassword(),"lagou",user2.getPassword())){
            return user2;
        } else {
            return null;
        }
    }

    //4.测试用户注册（加密）
    @Override
    public void register(User user) throws Exception {
        //封装数据
        Date date = new Date();
        user.setCreate_time(date);
        user.setUpdate_time(date);

        //对密码进行 加密
        String lagou = Md5.md5(user.getPassword(), "lagou");
        user.setPassword(lagou);

        //调用Mapper方法
        userMapper.register(user);
    }

    //5.根据用户id查询所关联的当前角色信息(回显)
    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        List<Role> list = userMapper.findUserRelationRoleById(id);
        return list;
    }

    //6.分配角色
    @Override
    public void userContextRole(UserVO userVO) {
        //根据用户id清空中间表的关联关系
        userMapper.deleteUserContextRole(userVO.getUserId());

        //向中间表添加记录
        List<Integer> roleIdList = userVO.getRoleIdList();
        for (Integer roleid : roleIdList) {
            //封装数据
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVO.getUserId());
            user_role_relation.setRoleId(roleid);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);

            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");

            userMapper.userContextRole(user_role_relation);
        }
    }

    //7.获取用户权限，进行菜单动态展示
    @Override
    public ResponseResult getUserPermissions(Integer userId) {

        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userId);

        //2.获取角色ID，保存到list集合中
        List<Integer> roleIds = new ArrayList<>();

        for (Role role : roleList) {
            roleIds.add(role.getId());
        }

        //3.根据角色Id,查询父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);

        //4.查询父菜单关联的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }

        //5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        //6.封装数据并进行返回
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceList);

        return new ResponseResult(true,200,"该用户动态获取菜单成功",map);
    }


}
