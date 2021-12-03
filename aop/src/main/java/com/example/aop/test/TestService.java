package com.example.aop.test;

import org.springframework.stereotype.Service;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/2
 */
@Service
public class TestService {

    @ApiLog(title = "注解的标题", isSaveRequestData = false)
    public void save(String p1, int p2) {

        System.out.println("service: " + p1 + " " + p2);
    }

    public void update() {
        System.out.println("没有拦截update");
    }
}
