package com.wschase.singleton;

/**单例设计模式——懒汉式
 * 不管怎么样先把对象加载出来
 * Author:WSChase
 * Created:2019/4/13
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE=new Singleton1();

    //此外我们还希望我们定义的这个不想不被外界修改，所以我们将这个类的构造方法定义为私有不让外界访问
    private Singleton1(){

    }

    //我们定义了这个对象但是外界需要获取这个私有的对象，所以我们需要提供一个方法
    public Singleton1 getInstance(){
        return INSTANCE;
    }

}
