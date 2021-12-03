package com.tomgao.tomchat.callbacktest;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/11/24
 */
public interface Callback {

    /**
     * 一个回调函数
     * @param object 接收对象
     */
    void accept(Object object);
}
