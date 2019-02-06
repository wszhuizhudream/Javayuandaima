package com.bittech.reflect.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class ProxyFactory {
    
    
    public static Object getInstance(Class realObjectClass, Class proxyObjectClass) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        //实际的对象
        Object realObject = realObjectClass.newInstance();
        // ProxySubject(ISubject target)
        //代理类的构造方法
        Constructor constructor = proxyObjectClass.getConstructor(
                proxyObjectClass.getInterfaces()[0]);
        //代理类的构造方法获取代理对象
        Object proxyObject = constructor.newInstance(realObject);
        return proxyObject;
    }
    
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ISubject subject = (ISubject) ProxyFactory.getInstance(RealSubject.class, ProxySubject.class);
        subject.eat();
    }
    
}
