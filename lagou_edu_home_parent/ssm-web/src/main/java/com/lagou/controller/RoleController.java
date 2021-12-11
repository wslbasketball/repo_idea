package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import com.mysql.fabric.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wsl
 * @Date 2021/12/5 19:29
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    //1.根据角色名称查询角色列表信息
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> allRole = roleService.findAllRole(role);

        return new ResponseResult(true,200,"角色列表&条件查询成功",allRole);
    }

    //2.查询所有的父子菜单信息（第一个接口）
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){

        //-1 表示查询所有的父子菜单信息
        List<Menu> menuListByPid = menuService.findSubMenuListByPid(-1);

        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuListByPid);

        ResponseResult responseResult = new ResponseResult(true,200,"查询所有父子菜单信息成功",map);
        return responseResult;
    }

    //3.根据角色ID查询角色所关联的菜单信息
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){

        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);

        return new ResponseResult(true,200,"根据角色ID查询关联菜单信息成功",menuByRoleId);
    }


    //4.为角色分配菜单信息
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVO roleMenuVO){

        roleService.roleContextMenu(roleMenuVO);

        return new ResponseResult(true,200,"为角色分配菜单列表信息成功",null);
    }

    //5.删除角色
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);

        return new ResponseResult(true,200,"删除角色成功",null);
    }

    //6.添加&修改角色
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role){

        //判断是否携带角色ID,携带为修改操作，不携带为新增操作
        if (role.getId() == null){
            //新增操作
            roleService.saveRole(role);
            return new ResponseResult(true,200,"新增角色成功",null);
        } else {
            //修改操作
            roleService.updateRole(role);
            return new ResponseResult(true,200,"更新角色成功",null);
        }

    }

    //7.根据roleId回显角色信息
    @RequestMapping("/findRoleById")
    public ResponseResult findRoleById(Integer id){

        Role role = roleService.findRoleById(id);

        return new ResponseResult(true,200,"根据ID回显角色信息成功",role);
    }

    //8.根据角色id查询角色所关联的资源信息
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(Integer roleId){

        List<ResourceCategory> resourceList = roleService.findResourceCategoryListByRoleId(roleId);

        return new ResponseResult(true,200,"根据角色ID查询关联的资源信息成功", resourceList);
    }

    //9.为角色分配资源信息
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVO roleResourceVO){

        roleService.roleContextResource(roleResourceVO);

        return new ResponseResult(true,200,"为角色分配资源信息成功",null);
    }

}
