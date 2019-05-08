package com.wschase.singleton;

/**单例设计模式——饿汉式
 * 先不实例化对象，外界获取的时候进行检验，如果没有再创建
 * Author:WSChase
 * Created:2019/4/13
 */
public class Singleton2 {
    //首先声明一个对象
    private static Singleton2 instance=null;

    private Singleton2(){

    }

    //然后定义一个方法来实现返回对象给外部
    public Singleton2 getInstance(){
    //在饿汉式里面我们返回对象的时候需要检验这个对象是否已经创建，如果已经创建那么就直接返回
    if(instance==null){
        instance=new Singleton2();
    }

    //如果已经有对象了那么直接返回对象
    return instance;
    }
}
