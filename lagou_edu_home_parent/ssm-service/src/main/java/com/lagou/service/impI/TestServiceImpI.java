package com.lagou.service.impI;

import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/29 22:35
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class TestServiceImpI implements TestService {

    @Autowired
    private TestMapper testMapper;

    //1.查询所有用户信息
    @Override
    public List<Test> findAllUser() {
        List<Test> allTest = testMapper.findAllUser();
        return allTest;
    }
}
