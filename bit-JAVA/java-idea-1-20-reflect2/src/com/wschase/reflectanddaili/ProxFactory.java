package com.wschase.reflectanddaili;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:WSChase
 * Created:2019/1/20
 */
public class ProxFactory {


    public static Object getInstance(Class realObjectClass,Class proxyObjectClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       //实际的对象
        Object realObject=realObjectClass.newInstance();

        //ProxySubject(ISubject target)
        //代理类的构造方法
       Constructor constructor= proxyObjectClass.getConstructor(
                proxyObjectClass.getInterfaces()[0]);

       //代理类的构造方法获取代理对象
       Object proxyObject=constructor.newInstance(realObject);
       return proxyObject;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ISubject subject=(ISubject) ProxFactory.getInstance(RealSubject.class,ProxSubject.class);
        subject.eate();
    }
}
