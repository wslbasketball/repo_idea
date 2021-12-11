package com.lagou.controller;

import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/29 22:54
 * @Project_Name lagou_edu_home_parent
 */
@RestController //@Controller + @ResponseBody
@RequestMapping("/user")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/findAllUser")
    public List<Test> findAllUser(){
        List<Test> allTest = testService.findAllUser();
        return allTest;
    }
}
