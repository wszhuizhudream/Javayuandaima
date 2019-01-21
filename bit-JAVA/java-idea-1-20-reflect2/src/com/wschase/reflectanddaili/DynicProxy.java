package com.wschase.reflectanddaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理
 * Author:WSChase
 * Created:2019/1/20
 */
public class DynicProxy {

    public static void main(String[] args) {

        //1.被代理对象
        ISubject realObject=new RealSubject();

        //2.代理对象的扩展
        ProxyHander hander=new ProxyHander(realObject);

        //3.代理对象
       ISubject ProxyObject= (ISubject) Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),//这里和获得了所有的接口，同时我们可以指定具体是哪个接口->new Class[]{ISubject.class}
                hander);
       ProxyObject.eate();

    }

}

/**
 * ProxyHander:对真实类的功能进行扩展
 */
class ProxyHander implements InvocationHandler{
    private Object target;

    public ProxyHander(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retVal;

        System.out.println("真实对象方法执行之前增强");

        retVal=method.invoke(this.target,args);
        System.out.println("真实对象方法执行之后增强");
        return retVal;
    }
}
