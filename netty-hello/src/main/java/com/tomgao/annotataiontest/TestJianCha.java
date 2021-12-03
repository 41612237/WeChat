package com.tomgao.annotataiontest;

import java.lang.reflect.Method;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/1
 */
public class TestJianCha {

    public static void main(String[] args) {
        NoBug noBug = new NoBug();
        Class clazz = noBug.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        // 记录日志
        StringBuilder log = new StringBuilder();
        // 记录异常次数
        int errorNum = 0;

        for (Method method : methods) {
            // 拿到被标注@jancha注解的方法
            if (method.isAnnotationPresent(jiancha.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(noBug, null);
                } catch (Exception e) {
                    errorNum+=1;
                    log.append(method.getName() + " " + "has error: \n caused by " + e.getCause().getClass().getSimpleName() + "\n");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errorNum);
        log.append(" error.");
        // 生成测试报告
        System.out.println(log.toString());
    }
}
