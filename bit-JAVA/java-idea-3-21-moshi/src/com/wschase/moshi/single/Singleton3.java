package com.wschase.moshi.single;

/**单例模式——双从检查
 * Author:WSChase
 * Created:2019/3/21
 */
public class Singleton3 {
    private static volatile Singleton3 instance3;

    private Singleton3(){}

    public Singleton3 getInstance3(){
        if(instance3==null){
            synchronized (Singleton3.class){
                if(instance3==null){
                    instance3=new Singleton3();
                }
            }
        }
        return instance3;
    }
}
