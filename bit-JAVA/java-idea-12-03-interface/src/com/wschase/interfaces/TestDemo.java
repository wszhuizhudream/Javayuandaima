package com.wschase.interfaces;

/**
 * Author:WSChase
 * Created:2018/12/3
 */
//1.在接口中定义普通方法
//interface IMessage{
//    //在接口中定义普通方法需要用到default这个关键字，但是它不表示
//    //这个方法的权限是default，我们不违背前面所学内容，在interface中
//    //只有public这个权限。
//    public default void fun(){
//        System.out.println("Heollo IMessage");
//    }
//    public void print();
//}
//class MessageImpl implements IMessage{
//    @Override
//    public void print() {
//        System.out.println("Hello MessageImpl");
//    }
//}
//public class TestDemo {
//    public static void main(String[] args) {
//        IMessage message = new MessageImpl();
//        message.print();
//        message.fun();
//    }
//}

//2.定义static方法
interface IMessage{
    //定义了普通方法
    public default void fun(){
        System.out.println("Hello IMessage");
    }
    //静态方法就和类里面的静态方法相似，可以直接由（类名）接口名称调用
    public static IMessage getInstance(){
        return new MessageImpl();
    }
    public void print();
}
class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("Hello MessageImpl");
    }
}
public class TestDemo{
    public static void main(String[] args) {
        IMessage message=IMessage.getInstance();
        System.out.println(message);
        message.print();
    }
}