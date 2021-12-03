package com.example.aop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/2
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/tomgao")
    public void test() {
        testService.save("111111", 66666);
        testService.update();
    }
}
