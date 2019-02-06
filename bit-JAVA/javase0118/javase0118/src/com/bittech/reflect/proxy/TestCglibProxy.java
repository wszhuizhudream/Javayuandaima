package com.bittech.reflect.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestCglibProxy {
    
    public static void main(String[] args) {
        Message message = new Message();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(message.getClass());
        enhancer.setCallback(new MessageEnhance(message));
        Message message2 = (Message) enhancer.create();
        message2.send();
    }
}

class Message {
    
    void send() {
        System.out.println("Message类发送消息");
    }
}

class MessageEnhance implements MethodInterceptor {
    
    private final Object target;
    
    MessageEnhance(Object target) {
        this.target = target;
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Object o " + o.getClass());
        System.out.println("MethodProxy methodProxy " + method.getName());
        Object retVal;
        System.out.println("发送之前");
        retVal = method.invoke(target, objects);
        System.out.println("发送之后");
        return retVal;
        
    }
}