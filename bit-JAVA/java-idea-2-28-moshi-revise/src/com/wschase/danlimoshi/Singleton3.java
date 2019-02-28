package com.wschase.danlimoshi;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

/**4.静态内部类方法
 * Author:WSChase
 * Created:2019/2/28
 */
//public class Singleton3 {
//    private Singleton3(){
//
//    }
//
//    private static class GetSingletonInstance{
//        private static final Singleton3 INSTANCE=new Singleton3();//这个和饿汉式的方法是一样的
//    }
//
//    public static Singleton3 getInstance3(){
//        return GetSingletonInstance.INSTANCE;
//    }
//}
////这个方法的原理是只会在第一次加载类的时候初始化，JVM保证了线程安全

public class Singleton3{
    private Singleton3(){

    }

    private static class GetSingletonInstance{
        private static final Singleton3 INSTANCE=new Singleton3();
    }

    public static Singleton3 getInstance3(){
        return GetSingletonInstance.INSTANCE;
    }
}
























