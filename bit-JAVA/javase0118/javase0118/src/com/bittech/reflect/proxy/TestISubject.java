package com.bittech.reflect.proxy;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestISubject {
    
    public static void main(String[] args) {
        ISubject realObject = new RealSubject();
        ISubject proxyObject = new ProxySubject(realObject);
        proxyObject.eat();
    }
}
