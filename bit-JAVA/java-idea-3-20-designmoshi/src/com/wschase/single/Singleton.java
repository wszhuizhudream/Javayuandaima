package com.wschase.single;

/**单例设计模式:静态常量的方法
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton {
    //实例化对象
    private static final Singleton INSTANCE=new Singleton();

    //将构造方法的权限设置为私有的，这样就只有本来才可以进行访问进行修改
    private Singleton(){

    }

    //专门定义一个方法这个方法来返回实例化对象
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
