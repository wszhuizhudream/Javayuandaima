package com.wschase.single;

/**
 * Author:WSChase
 * Created:2019/3/20
 */
public class Singletion1 {
    private static Singletion1 instance=null;

    private Singletion1(){}

    public static Singletion1 getInstance(){
        if(instance==null){
            instance=new Singletion1();
        }
        return instance;
    }

}
