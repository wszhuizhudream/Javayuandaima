package com.wschase.moshi.single;

/**单例设计模式——懒汉式
 * 特点就是：不管什么时候先把对象实例化
 * Author:WSChase
 * Created:2019/3/21
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE=new Singleton1();

    //为了不让外部修改我们的类，所以将它定义为私有的
    private Singleton1(){}

    public Singleton1 getInstance(){
        return INSTANCE;
    }

}
