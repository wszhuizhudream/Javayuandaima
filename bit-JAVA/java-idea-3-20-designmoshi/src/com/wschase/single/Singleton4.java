package com.wschase.single;

/**单例设计模式——静态内部类
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton4 {
    private Singleton4(){}

    static class Singleton4Instance{
        private static final Singleton4 INSTANCE=new Singleton4();
    }

    public Singleton4 getInstance(){
        //通过静态内部类的特性来获取一个唯一的对象
        return Singleton4Instance.INSTANCE;
    }
}
