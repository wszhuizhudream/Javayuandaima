package com.wschase.javase.revise1.object;

/**定义下非主类的静态代码块
 * Author:WSChase
 * Created:2019/3/15
 */
class Person1{
    //静态块
    static {
        System.out.println("这是静态块");
    }

    //构造块
    {
        System.out.println("这是构造块");
    }

    //构造方法
    public Person1(){
        System.out.println("这是Person的构造方法");
    }

        }
public class Test4 {
    public static void main(String[] args) {
//        new Person1();
//        new Person1();

        //在主类和不在主类的静态块最大的区别是：
        //当我们在主类的静态块，没有创建对象，也会加载这个类，那么这个
        //静态块就会被JVm加载；但是不在主类的静态块如果没有创建对象，对这个类
        //进行加载的话，那么它将不会被执行。
    }
}
