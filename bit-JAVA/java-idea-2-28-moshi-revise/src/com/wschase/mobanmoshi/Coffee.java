package com.wschase.mobanmoshi;

/**
 * Author:WSChase
 * Created:2019/2/27
 */
public class Coffee extends DrinkBrever {

    @Override
    public void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    public void addSupice() {
        System.out.println("加糖或牛奶");
    }
}
