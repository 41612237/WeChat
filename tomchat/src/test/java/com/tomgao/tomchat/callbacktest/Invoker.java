package com.tomgao.tomchat.callbacktest;

import java.io.Serializable;

/**
 * @author tomgao
 * @Description 调用者
 * @Date 创建于 2021/11/24
 */

public class Invoker implements Callback, Serializable {

    private Handler handler;

    public Invoker(Handler handler) {
        this.handler = handler;
    }

    public void invoke(int num) {
        new Thread(() -> {
            try {
                handler.handlerData(this, num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    @Override
    public void accept(Object object) {
        System.out.println(object);
    }
}
