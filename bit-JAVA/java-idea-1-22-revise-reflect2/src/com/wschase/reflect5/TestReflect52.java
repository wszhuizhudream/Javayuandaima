package com.wschase.reflect5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理设计模式（重点）
 * 核心在于：一个代理类可以代理所有需要被代理的接口的子类对象；
 * 要想进行动态代理设计的实现，代理类不再具体实现某一个接口
 * Author:WSChase
 * Created:2019/1/23
 */
interface ISubject{
    //核心操作接口
    public void eat(String msg,int num);
}

class RealSubject implements ISubject{

    @Override
    public void eat(String msg, int num) {
        System.out.println("我要吃"+num+"分量的"+msg);
    }
}

/**
 * 动态代理类
 */
class ProxySubject implements InvocationHandler{

    //这个是任意接口的对象，所以使用Object描述
    private Object target;//

    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target
     * @return 返回一个代理对象（这个对象是根据接口定义动态创建生成的代理对象）
     */
    public Object bind(Object target){//这个方法才是核心方法
        //保存真实主题对象
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public void preHandle(){
        System.out.println("[ProxySubject] 方法处理前");
    }

    public void afterHandle(){
        System.out.println("[ProxySubject] 方法处理后");
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

public class TestReflect52 {
    public static void main(String[] args) {
        //通过直接传入一个对象不是具体的某个接口我们实现了对象的创建
        ISubject subject= (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("西红柿鸡蛋",10);
    }
}
