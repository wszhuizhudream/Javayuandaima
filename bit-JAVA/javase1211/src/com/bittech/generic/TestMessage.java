package com.bittech.generic;

/**
 * Author: secondriver
 * Created: 2018/12/11
 */
public class TestMessage {

//    public static void fun(Message2<String> message) {
//        System.out.println(message.getMessage());
//    }
    
    //泛型参数 ？ 通配符解决参数统一的问题
    public static void fun(Message2<?> message) {
        //message.setMessage(111); 此处不能修改
        System.out.println(message.getMessage());
    }
    
    //Number  泛型的上限
    public static void fun2(Message2<? extends Number> message) {
//        message.setMessage(new Double(11D));//不能修改内容
        System.out.println(message.getMessage());
    }
    
    //泛型的下限
    public static void fun3(Message2<? super String> message) {
        message.setMessage("hello");//可以修改内容
//        message.setMessage(new Object());
        System.out.println(message.getMessage());
    }
    
    
    public static void main(String[] args) {
        Message2<String> message2 = new Message2<>();
        message2.setMessage("hello");
        fun3(message2);
        
        Message2<Integer> message21 = new Message2<>();
        message21.setMessage(100);
        // fun3(message21);
        
        Message3<Number> message3 = new Message3<>();
        //Message3<String> message31 = new Message3<String>();
        
    }
    
}

class Message2<T> {
    
    private T message;
    
    public T getMessage() {
        return message;
    }
    
    public void setMessage(T message) {
        this.message = message;
    }
}

//泛型上限在泛型类定义时使用
class Message3<T extends Number> {
    
    private T message;
    
    public T getMessage() {
        return message;
    }
    
    public void setMessage(T message) {
        this.message = message;
    }
}