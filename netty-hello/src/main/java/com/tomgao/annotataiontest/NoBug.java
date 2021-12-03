package com.tomgao.annotataiontest;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/12/1
 */
public class NoBug {

    @jiancha
    public void plus() {
        System.out.println(1+1);
    }

    @jiancha
    public void sub() {
        System.out.println(2-5);
    }

    @jiancha
    public void mul() {
        System.out.println(6*6);
    }

    @jiancha
    public void div() {
        System.out.println(1/0);
    }
}
