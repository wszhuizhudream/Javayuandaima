package com.wschase.single;

/**双重检查
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton2 {
    private static volatile Singleton2 singleton2;
    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(singleton2==null){
            synchronized (Singleton2.class){
                if(singleton2==null){
                    singleton2=new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
