package com.wschase.danlimoshi;

/**单例设计模式特别重要——它经常出现在笔试中需要我们手写单例
 * 单例设计就是我们经过一个类只能创建一个对象
 * 下面我们主要掌握5种模式：懒汉式、饿汉式、静态内部类的写法、双重检查的写法、枚举的写法
 * Author:WSChase
 * Created:2019/2/28
 */
////1.饿汉式单例：立即初始化、立即加载、线程安全、但是内存可能会被浪费
//public class Singleton {
//    //将这个类的构造方法定义为私有的，就只能创建一个对象
//    //用final修饰以后就成为了常量，常量只能有一个，这样就满足单例的条件
//    private static final Singleton INSTANCE=new Singleton();
//    private Singleton(){
//
//    }
//    //定义一个方法来实现获得对象
//    public static Singleton getInstance(){
//        //因为在这个方法里面我们需要访问静态的变量，所以这个方法就需要是静态的
//        return INSTANCE;
//    }
//}



//1.饿汉式单例
public class Singleton{
    private static final Singleton INSTANCE=new Singleton();

    private Singleton(){

    }
    public static Singleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {

    }
}
























