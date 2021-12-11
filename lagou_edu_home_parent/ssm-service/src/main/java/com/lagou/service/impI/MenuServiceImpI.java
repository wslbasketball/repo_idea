package com.lagou.service.impI;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/5 20:21
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class MenuServiceImpI implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    //1.查询所有的父子菜单信息
    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> menuListByPid = menuMapper.findSubMenuListByPid(pid);
        return menuListByPid;
    }

    //2.查询所有菜单列表
    @Override
    public List<Menu> findAllMenu() {
        List<Menu> allMenu = menuMapper.findAllMenu();
        return allMenu;
    }

    //3.根据id回显菜单信息（修改操作）
    @Override
    public Menu findMenuById(Integer id) {
        Menu menu = menuMapper.findMenuById(id);
        return menu;
    }

    //4.新增菜单
    @Override
    public void saveMenu(Menu menu) {
        //封装数据
        Date date = new Date();
        menu.setCreatedTime(date);
        menu.setUpdatedTime(date);

        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");

        menuMapper.saveMenu(menu);
    }

    //5.更新菜单
    @Override
    public void updateMenu(Menu menu) {
        //封装数据
        menu.setUpdatedTime(new Date());

        menu.setUpdatedBy("system");

        menuMapper.updateMenu(menu);
    }

    //6.删除菜单
    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteMenu(id);
    }


}
