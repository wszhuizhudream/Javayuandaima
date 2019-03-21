package com.wschase.single;

/**单例——饿汉式
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singleton6 {
    private static Singleton6 instance=null;//先初始化
    private Singleton6(){}

    public Singleton6 getInstance(){
        if(instance==null){
            instance=new Singleton6();
        }
        return instance;
    }
}
