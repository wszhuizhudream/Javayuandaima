package com.wschase.mobanmoshi;

/**
 * Author:WSChase
 * Created:2019/2/27
 */
public class Tea extends DrinkBrever {
    @Override
    public void brew() {
        System.out.println("用沸水将茶叶浸泡");
    }

    @Override
    public void addSupice() {
        System.out.println("加入柠檬");
    }
}
