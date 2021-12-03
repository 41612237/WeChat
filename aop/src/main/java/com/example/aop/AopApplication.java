package com.example.aop;

import com.example.aop.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {


    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

}
