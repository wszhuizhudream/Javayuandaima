package com.wschase.singleton;

/**单例设计模式——静态内部类
 * 我们利用静态内部类只被加载一次的特点实现单例设计模式
 * Author:WSChase
 * Created:2019/4/13
 */
public class Singleton3 {

    private Singleton3() {

    }

    //我们根据静态内部类的特点，它值加载一次，所以这个对象只会被实例化一次
    static class Instacnce{
        private static final Singleton3 INSTANCE=new Singleton3();
    }


    public Singleton3 getInstance(){
        return Instacnce.INSTANCE;
    }
}
