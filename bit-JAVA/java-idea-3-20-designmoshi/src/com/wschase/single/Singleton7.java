package com.wschase.single;

/**单例——双重检查
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton7 {
    private static volatile Singleton7 singleton7=null;
    private Singleton7(){}

    public Singleton7 getInstance(){
        if(singleton7==null){
            synchronized (Singleton7.class){
                if(singleton7==null){
                    singleton7=new Singleton7();
                }
            }
        }
        return singleton7;
    }
}
