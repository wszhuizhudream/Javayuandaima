package com.wschase.mobanmoshi;

/**
 * Author:WSChase
 * Created:2019/2/27
 */
 abstract class DrinkBrever {
    final void prepar() {//在这个抽像类中我们定义的是冲泡的步骤
        boilWater();//将水煮沸
        brew();//冲泡
        putIntoCup();//倒入杯中
        addSupice();//加料
    }
    public void boilWater(){
        System.out.println("将水煮沸");
    }

    //将不同的特性定义为抽象方法，让子类来实现
    public abstract void brew();

    public void putIntoCup(){
        System.out.println("将饮料倒入杯中");
    }

    public abstract void addSupice();

}
