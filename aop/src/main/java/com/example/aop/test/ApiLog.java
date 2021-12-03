package com.example.aop.test;

import java.lang.annotation.*;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/2
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 模块
     */
    public String title() default "";

    /**
     * 日志记录service实现
     * @return
     */
    public String logService() default "operLogServiceImpl";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否追踪用户操作
     * @return
     */
    public boolean isTrack() default true;
}
