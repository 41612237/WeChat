package com.tomgao.callbacktest;

import java.util.HashMap;

/**
 * @author tomgao
 * @Description 处理器
 * @Date 创建于 2021/11/24
 */
public class Handler {

    /**
     * 异步处理的函数 执行完业务之后callback调用者
     * @param callback
     * @param number
     * @throws InterruptedException
     */
    public void handlerData(Callback callback, int number) throws InterruptedException {
        Thread.sleep(3000);
        double res = Math.pow(number, 2);
        callback.accept(res);
    }
}
