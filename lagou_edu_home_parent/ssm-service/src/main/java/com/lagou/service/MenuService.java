package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.MenuVO;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/5 20:20
 * @Project_Name lagou_edu_home_parent
 */
public interface MenuService {

    /**
     * 1.查询所有的父子菜单信息
     */
    public List<Menu> findSubMenuListByPid(int pid);

    /**
     * 2.分页查询所有菜单列表
     */
    public PageInfo findAllMenuByPage(MenuVO menuVO);

    /**
     * 3.根据id回显菜单信息（修改操作）
     */
    public Menu findMenuById(Integer id);

     /**
     * 4.新增菜单
     */
    public void saveMenu(Menu menu);

    /**
     * 5.更新菜单
     */
    public void updateMenu(Menu menu);

    /**
     * 6.删除菜单
     */
    public void deleteMenu(Integer id);
}
