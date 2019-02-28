package com.wschase.danlimoshi;

/**2.懒汉式单例：延迟实例化、线程不安全但是可以在不使用对象的时候减少内存空间的开销
 * Author:WSChase
 * Created:2019/2/28
 */
//public class Singleton1 {
//    private static Singleton1 instance=null;//首先声明对象，这个时候不会在内存中开辟空间，不会浪费内存
//    private Singleton1(){
//
//    }
//    public static Singleton1 getInstance1(){
//        if(instance==null){
//            instance = new Singleton1();
//        }
//        return instance;
//    }
//}
////从上面我们可以看出来懒汉式和饿汉式最大的区别就是一个依赖就直接开辟对象的空间，但是另外一个是延迟加载的，当使用的时候没有了才会开辟空间

public class Singleton1{
    private static Singleton1 instance=null;
    private Singleton1(){

    }
    public static Singleton1 getInstance1(){
        if(instance==null){
            instance=new Singleton1();
        }
        return instance;
    }
}



















