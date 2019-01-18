package com.wschase.fanxing;

/**泛型之——通配符
 * 通配符是为了解决参数不统一的问题
 * Author:WSChase
 * Created:2019/1/16
 */

class Message<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
public class TestTongpeifu {
    public static void main(String[] args) {
        Message<String> message=new Message<>();//在泛型中指明了只能用String类型

//1.泛型的方法
        //(1)传入的是String类型的是正确的
        message.setMessage("年号");
        fun(message);

//        //（2）传入其他类型的是错误的
//        message.setMessage(99);
//        fun(message);//error

//2.通配符的方法——通配符的使用是对于泛型类来说它已经指定类型了，但是对于泛型方法来说它可以是任意类型

        message.setMessage("字符");
        fun(message);




      }


//1.使用泛型来解决
//    private static void fun(Message<String> message) {
//
//        System.out.println(message.getMessage());
//    }


//2.通过这个例子我们希望的是可以接收所有的泛型类型，但是又不能让用户随意修改，那么在这种情况下我们就可以使用通配符"?"来处理
public static void fun(Message<?> temp){
        //temp.setMessage(100);因为现在不知道具体是什么类型，所以不能修改
    System.out.println(temp.getMessage());
}
}
