package com.bittech.generic;

/**
 * Author: secondriver
 * Created: 2018/12/11
 */
public interface IMessage<T> {
    
    void print(T t);
    
    //JDK8 interface可以包含静态方法
    public static void code1() {
        //匿名内部类
//        IMessage<String> iMessage = new IMessage<String>() {
//            @Override
//            public void print(String s) {
//                System.out.println(s);
//            }
//        };

//        IMessage1<Integer> integerIMessage1 = new IMessage1<>();
//        integerIMessage1.print(100);
//        IMessage2 iMessage2 = new IMessage2();
//        iMessage2.print("hello");
    }
    
    public static void main(String[] args) {
//        Message<String> message1 = new Message<>("Hello");
        Message<Integer> message2 = new Message<>(100);
        
        try {
            System.out.println(
                    message2.getClass().getDeclaredField("message").getType().getName());
        } catch (NoSuchFieldException e) {
        
        }
        
        //定义：泛型信息存在于编译阶段，运行时会类型擦除
//        //1. instanceof
//        System.out.println(message1 instanceof Message);//true
//        System.out.println(message2 instanceof Message);//true
//
//        //2. getClass
//        System.out.println(message1.getClass().getName());//message1对象实例化的类型
//        System.out.println(message2.getClass().getName());
        
        Message3<Integer> integerMessage3 = new Message3<>();
        integerMessage3.setMessage(100);
        System.out.println(integerMessage3.getClass().getName());
        try {
            //Java反射机制-在运行时了解对象以及类的信息
            System.out.println(
                    integerMessage3.getClass().getDeclaredField("message").getType().getName());
            
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

//1.继续保留泛型参数
class IMessage1<T> implements IMessage<T> {
    
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}

//2.指定泛型参数的类型
class IMessage2 implements IMessage<String> {
    
    @Override
    public void print(String o) {
        System.out.println(o);
    }
}
