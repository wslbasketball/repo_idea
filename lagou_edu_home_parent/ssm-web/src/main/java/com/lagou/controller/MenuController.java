package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wsl
 * @Date 2021/12/5 23:43
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //1.查询所有菜单列表
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){

        List<Menu> allMenu = menuService.findAllMenu();

        return new ResponseResult(true,200,"查询菜单列表成功",allMenu);
    }

    //2.回显菜单信息（添加&修改）
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){

        //根据id的值判断当前是新增操作还是修改操作，判断id是否为-1
        if (id == -1){
            //新增操作，回显信息不需要查询menu信息
            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

            //封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList", subMenuListByPid);

            return new ResponseResult(true,200,"添加回显成功",map);

        } else {
            //修改操作，回显信息需要查询menu信息
            Menu menu = menuService.findMenuById(id);

            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

            //封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList", subMenuListByPid);

            return new ResponseResult(true,200,"修改回显成功",map);
        }
    }

    //3.新增&修改菜单
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu){

        //判断是否携带id,携带为修改操作，不携带为新增操作
        if (menu.getId() == null){
            //新增操作
            menuService.saveMenu(menu);
            return new ResponseResult(true,200,"新增菜单信息成功",null);
        } else {
            //修改操作
            menuService.updateMenu(menu);
            return new ResponseResult(true,200,"更新菜单信息成功",null);
        }
    }

    //4.删除菜单
    @RequestMapping("/deleteMenu")
    public ResponseResult deleteMenu(Integer id){

        menuService.deleteMenu(id);

        return new ResponseResult(true,200,"删除菜单信息成功",null);
    }

}
