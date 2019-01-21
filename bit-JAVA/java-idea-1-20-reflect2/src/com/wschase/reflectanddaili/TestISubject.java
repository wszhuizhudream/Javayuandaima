package com.wschase.reflectanddaili;

/**
 * Author:WSChase
 * Created:2019/1/20
 */
public class TestISubject {
    public static void main(String[] args) {
        ISubject realSubject=new RealSubject();
        ISubject proxSubject=new ProxSubject(realSubject);
        proxSubject.eate();
    }
}
