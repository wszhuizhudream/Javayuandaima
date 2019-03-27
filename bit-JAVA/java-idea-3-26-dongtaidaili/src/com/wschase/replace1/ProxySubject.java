package com.wschase.replace1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类：通过反射来实现
 * Author:WSChase
 * Created:2019/3/26
 */
public class ProxySubject implements InvocationHandler {
    //绑定任意接口对象，使用Object描述
    private Object target;

    /*
    实现真实对象的绑定处理，同时返回代理对象
     */
    public Object bind(Object target){
        //保存真实的对象
        this.target=target;
        return
                Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public void preHandle(){
        System.out.println("[ProxySubject]方法处理前");
    }
    public void afterHandle(){
        System.out.println("[ProxySubject]方法处理后");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();
        //反射调用方法
        Object ret=method.invoke(this.target,args);
        this.afterHandle();
        return ret;
    }
}
