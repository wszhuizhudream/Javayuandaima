package com.wschase.single;

/**静态内部类的写法
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton3 {
    private Singleton3(){}

    //静态内部类的特点就是只加载一次
    private static class SingletonInstance{
        private static final Singleton3 INSTANCE=new Singleton3();
    }
    public static Singleton3 getInstane(){
        return SingletonInstance.INSTANCE;
    }
}
