package com.wschase.singleton;

/**单例设计模式——双重检查
 * 首先第一次检查是为防止多线程造成线程不安全问题
 * 第二次检查是为了检查是否已经存在这个对象，如果不存在则创建
 * Author:WSChase
 * Created:2019/4/13
 */
public class Singleton4 {
    //首先声明一个需要返回的对象
    private static volatile Singleton4 instance=null;

    private Singleton4(){

    }

    public Singleton4 getInstance(){
        //第一次进来的时候判断是否为空，然后再进行加锁保证线程同步，再进行一次判断然后进行实例化
        if(instance==null){
         synchronized (Singleton4.class){//保证线程同步:全局锁
             if(instance==null){
                 instance=new Singleton4();
             }
         }
        }
        return instance;
    }
}
