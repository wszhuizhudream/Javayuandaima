package com.bittech.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class DynicProxy {
    
    public static void main(String[] args) {
        
        //1.被代理对象
        ISubject realObject = new RealSubject();
        //2.代理对象的扩展
        ProxyHandler handler = new ProxyHandler(realObject);
        
     //3.代理对象
        ISubject proxyObject = (ISubject) Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                new Class[]{ISubject.class}, //
                handler);
    
        System.out.println(proxyObject.getClass());
        proxyObject.eat();
    }
    
}

/**
 * ProxyHandler：对真实类的功能进行扩展
 */
class ProxyHandler implements InvocationHandler {
    
    private final Object target;
    
    ProxyHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retVal;
        System.out.println("真实对象方法执行之前增强");
        retVal = method.invoke(this.target, args);
        System.out.println("真实对象方法执行之后增强");
        return retVal;
    }
}
