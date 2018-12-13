package com.wschase.tongpeifu;


/**
 * Author:WSChase
 * Created:2018/12/12
 */
////泛型上限
//class Generics<T extends Number>{
//    private T obj;
//
//    public T getObj() {
//        return obj;
//    }
//
//    public void setObj(T obj) {
//        this.obj = obj;
//    }
//    public void show(Generics<?> T){
//        System.out.println("show():"+getObj());
//    }
//}
//public class TestGenerics {
//    public static void main(String[] args) {
//        Generics<Integer> generics1=new Generics<>();//创建Generics的实例化对象
//        generics1.setObj(20);
//        Generics<Double> generics2=new Generics<>();//实例化对象
//        generics2.setObj(12.05);
//        generics1.show(generics1);
//        info(generics1);
//        generics2.show(generics2);
//        info(generics2);
//    }
//    public static void info(Generics<? extends Number> t){//这个通配符就是上限的通配符，它所能接收的类型只能是Number的子类
//        //这个方法的作用是：接收Generics的任意对象并将其内容打印
//        System.out.println("info():"+t.getObj());
//    }
//}


//泛型下限
class Message<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
public class TestGenerics{
    public static void main(String[] args) {
        Message<String> message=new Message<>();
        message.setMessage("nihao");
        fun(message);
    }
    public static void fun(Message<? super String> temp){
        //泛型下限是可以修改的
        temp.setMessage("bit");//修改了我们开始的值
        System.out.println(temp.getMessage());
    }
}