package com.bittech.generic;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class Message<T> {
    
    private T message;
    
    public Message(T message) {
        this.message = message;
    }
    
    //泛型方法  和  泛型类  相互独立的
    
    // <T> returnValue methodName(T args)
    public static <T> void print(T data) {
        System.out.println(data);
    }
    
    public static <T, S> void print(T data, S value) {
    }
    
    public static <T> T convert(T data) {
        return data;
    }
    
    public T getMessage() {
        return message;
    }
    
    //成员方法，泛型方法
    public <E> void messagePrint(E value) {
        System.out.println(value);
    }
    
    public static void main(String[] args) {
//        print("hello");
//        print(22);
//        print(new Point2<>(22, "北纬30度"));
        
        Message<String> message = new Message<>("Java is best");
        System.out.println(message.getMessage());
        
        message.messagePrint(22);
        message.messagePrint("hello");

//        System.out.println(convert(22));
//        System.out.println(convert("HelloWorld"));
    }
    
    
}
