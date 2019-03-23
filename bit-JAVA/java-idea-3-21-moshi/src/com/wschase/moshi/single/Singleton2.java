package com.wschase.moshi.single;

/**单例模式——饿汉式
 * Author:WSChase
 * Created:2019/3/21
 */
public class Singleton2 {
    private static Singleton2 instance=null;//首先声明对象，但是并不实例化

    private Singleton2(){}

    public Singleton2 getInstance2(){
        if(instance==null){
            instance=new Singleton2();
        }
        return instance;
    }
}
