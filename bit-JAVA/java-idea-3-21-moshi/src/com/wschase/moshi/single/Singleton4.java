package com.wschase.moshi.single;

/**单例设计——内部类的方法
 * Author:WSChase
 * Created:2019/3/21
 */
public class Singleton4 {
    private Singleton4(){}

    static class Instance{
        private static final Singleton4 INSTANCE4=new Singleton4();
    }
    public Singleton4 getInstacne(){
        return Instance.INSTANCE4;
    }
}
