package com.wschase.replace1;

/**
 * Author:WSChase
 * Created:2019/3/26
 */
public class RealSubject implements ISubject {
    @Override
    public void eat(String msg, int num) {
        System.out.println("我要吃"+num+"分量的"+msg);
    }
}

