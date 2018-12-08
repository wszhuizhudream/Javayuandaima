package com.bittech.classandobject2;

/**对于代码块我们的执行顺序是不同的，我们下面就看一下这些代码块的执行顺序到底是什么样的
 * Author:WSChase
 * Created:2018/12/3
 */
class HelloA{//主要看一下非静态代码块和构造方法谁先执行
    public HelloA(){
        System.out.println("1.这是A构造方法");
    }
    {
        System.out.println("2.这是A非静态代码块");
    }
    static{
        System.out.println("3.这是A静态代码块");
    }
}
class HelloB extends HelloA{
    public HelloB(){
        System.out.println("4.这是B构造方法");
    }
    //这个也叫构造块
    {
        System.out.println("5.这是B非静态代码块");
    }
    static{
        System.out.println("6.这是B静态块");
    }
}
public class TestCode {
    public static void main(String[] args) {
        System.out.println("-------7.statr-------");
        new HelloB();
        new HelloA();
        System.out.println("-------8.end---------");
    }
}
//这个代码执行出来结果的顺序是：7->3->6->2->1->5->4->2->1->8
