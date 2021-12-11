package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/29 22:05
 * @Project_Name lagou_edu_home_parent
 */
public interface TestMapper {

    /**
     * 1.查询所有用户信息
     */
    public List<Test> findAllUser();
}
