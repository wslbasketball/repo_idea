package com.lagou.service;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/29 22:34
 * @Project_Name lagou_edu_home_parent
 */
public interface TestService {

    /**
     * 1.查询所有用户信息
     */
    public List<Test> findAllUser();

}
