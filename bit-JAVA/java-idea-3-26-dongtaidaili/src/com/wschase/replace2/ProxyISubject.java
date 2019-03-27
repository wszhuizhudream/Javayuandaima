package com.wschase.replace2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**代理类
 * Author:WSChase
 * Created:2019/3/26
 */
public class ProxyISubject implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target=target;

        //当前对象进行处理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public void preHandle(){
        System.out.println("点单");
    }
    public void afterHandle(){
        System.out.println("结账");
    }

    //这个方法就是专门用来实现代理模式的方法。是属于反射中的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();

        Object ret=method.invoke(this.target,args);
        this.afterHandle();
        return ret;
    }
}
