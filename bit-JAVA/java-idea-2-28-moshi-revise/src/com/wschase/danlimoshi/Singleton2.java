package com.wschase.danlimoshi;

/**3.双重检查的方法:所有的单例的写法原理都是一样的：
 * 先声明一个对象私有的、静态的
 * 构造方法都是私有的
 * Author:WSChase
 * Created:2019/2/28
 */
//public class Singleton2 {
//    private static volatile Singleton2 instance;
//    private Singleton2(){
//
//    }
//    public static Singleton2 getInstance(){
//        if(instance==null){//第一次检查
//            synchronized (Singleton2.class){
//                if(instance==null){
//                    instance=new Singleton2();
//                }
//            }
//        }
//        return instance;
//    }
//}

public class Singleton2{
    private static volatile Singleton2 instance;
    private Singleton2(){

    }
    public static Singleton2 getInstance2(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance==null){
                    instance=new Singleton2();
                }
            }
        }
        return instance;
    }
}




















