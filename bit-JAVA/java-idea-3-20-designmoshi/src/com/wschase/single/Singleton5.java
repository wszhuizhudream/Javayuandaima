package com.wschase.single;

/**单例——懒汉式
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton5 {
    private static final Singleton5 INSTANCE=new Singleton5();

    private Singleton5(){}

    public Singleton5 getInstance(){
        return INSTANCE;
    }
}
