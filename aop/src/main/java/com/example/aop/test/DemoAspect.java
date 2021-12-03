package com.example.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/2
 */
@Component
@Aspect
public class DemoAspect {

    // 切入点
    @Pointcut("execution(public * com.example.aop.test.*.save(..))")
    public void save() {

    }

    @Before("save()")
    public void before(JoinPoint joinPoint) {

        Object target = joinPoint.getTarget();
        System.out.println(target.getClass().getName());
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法名: " + methodName);
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            ApiLog apiLog = method.getAnnotation(ApiLog.class);
            System.out.println("切入的注解title: " + apiLog.title());
        }

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("参数: " + arg);
        }
    }
}
