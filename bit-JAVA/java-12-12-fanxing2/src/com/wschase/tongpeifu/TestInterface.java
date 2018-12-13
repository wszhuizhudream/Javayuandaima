package com.wschase.tongpeifu;

/**泛型接口的实现
 * Author:WSChase
 * Created:2018/12/12
 */
//public interface IMessage<T>{
//    void print(T t);
//}
//public class TestInterface {
//    public static void main(String[] args) {
////    （1）匿名内部类实现:在创建接口的对象的时候我们将指定具体的类型
//        IMessage<String> iMessage =new IMessage<String>() {
//            @Override
//            public void print(String s) {
//                System.out.println(s);
//            }
//        };
//
//    }
//}
////    （2）在子类定义时继续使用泛型
//class IMessage1<T> implements IMessage{
//
//    @Override
//    public void print(T t) {
//        System.out.println(t);
//    }
//}
//
////    （3）在子类实现接口的时候明确给出具体类型
//class IMessage2 implements IMessage<String>{
//
//    @Override
//    public void print(String s) {
//        System.out.println(s);
//    }
//}
