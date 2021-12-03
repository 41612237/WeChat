package com.tomgao.callbacktest;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/11/24
 */
public class Test {

    public static void main(String[] args) {
        Handler handler = new Handler();
        Invoker invoker = new Invoker(handler);
        invoker.invoke(7);
    }
}
