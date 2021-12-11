package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wsl
 * @Date 2021/12/4 22:20
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //1.用户分页查询&多条件组合查询
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO){

        PageInfo pageInfo = userService.findAllUserByPage(userVO);

        ResponseResult responseResult = new ResponseResult(true,200,"用户分页&多条件组合查询成功",pageInfo);
        return responseResult;
    }

    //2.更新用户状态: ENABLE能登录，DISABLE不能登录
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id,String status){

        userService.updateUserStatus(id,status);

        return new ResponseResult(true,200,"更新用户状态成功",status);
    }

    //3.用户登录（根据用户名查询具体的用户信息）
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {

        User user1 = userService.login(user);

        //判断user1是否为空
        if (user1 != null){
            //保存access_token和用户id到session中
            HttpSession session = request.getSession();
            //随机数
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            session.setAttribute("user_id",user1.getId());

            //使用map集合封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("access_token",access_token);
            map.put("user_id",user1.getId());

            //将查询出来的user也存到map中
            map.put("user",user1);

            return new ResponseResult(true,1,"用户登录成功",map);

        } else {
            return new ResponseResult(true,400,"用户名或密码错误",null);
        }
    }

    //4.测试用户注册（加密）
    @RequestMapping("/register")
    public ResponseResult register(@RequestBody User user) throws Exception {

        userService.register(user);

        return new ResponseResult(true,200,"用户注册成功",null);
    }

    //5.根据用户id查询所关联的当前角色信息(回显)
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(Integer id){

        List<Role> roleList = userService.findUserRelationRoleById(id);

        return new ResponseResult(true,200,"分配角色(回显)成功",roleList);
    }

    //6.分配角色
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO){

        userService.userContextRole(userVO);

        return new ResponseResult(true,200,"分配角色成功",null);
    }

    //7.获取用户权限，进行菜单动态展示
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){

        //1.获取请求头中token
        String header_token = request.getHeader("Authorization");

        //2.获取session中的token
        String session_token = (String) request.getSession().getAttribute("access_token");

        //3.判断token是否一致
        if (header_token.equals(session_token)){
            //4.获取用户id
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");

            //5.调用service,进行菜单信息查询
            ResponseResult responseResult = userService.getUserPermissions(user_id);

            return responseResult;
        } else {
            ResponseResult responseResult = new ResponseResult(false,400,"动态获取菜单失败",null);
            return responseResult;
        }
    }


}
