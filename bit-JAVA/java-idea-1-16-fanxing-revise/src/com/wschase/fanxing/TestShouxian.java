package com.wschase.fanxing;

/**受限泛型
 * 1.？ extends 类名：设置泛型上限
 * 2.？ extends 类名：设置泛型下限
 * Author:WSChase
 * Created:2019/1/16
 */
//1.设置泛型上限
class Message2<T extends Number>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message ) {
        this.message = message;
    }
}

//2.设置泛型下限
class Message1<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}



public class TestShouxian {
    public static void main(String[] args) {

        //1.泛型上限
        Message2<Integer> message=new Message2<>();
        message.setMessage(33);
        fun2(message);

        //2.泛型下限
        Message1<String> message1=new Message1<>();
        message1.setMessage("hello world");
        System.out.println("经过修改以后的值为：");
        fun1(message1);

    }


    //1.设置泛型上限
    //使用通配符来定义方法
    public static void fun2(Message2<? extends Number> temp){
        //在这是不可以修改值的，因为泛型上限传入的是Number及其子类，如果后面调用方法的时候传入的是其子类，那么需要实现向下转型
        //我们前面学习过类型的转，实现向下转型是需要强制类型转化的，所以这里行不通，在设置泛型上限的时候不可以修改值。
        System.out.println(temp.getMessage());
    }

    //2.设置泛型下限
    public static void fun1(Message1<? super String> temp){
        //此时可以修改值，因为泛型下限是它及其父类——实现的是向上转型
        temp.setMessage("hello");
        System.out.println(temp.getMessage());
    }
}
