package com.wschase.javase.revise1.object;

/**静态代码块
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test3 {
    //（1）在主类中的静态代码块
    //静态块
    static {
        System.out.println("这是静态块");
    }
    //构造块
    {
        System.out.println("这是构造块");
    }
    //构造方法
    public Test3(){
        System.out.println("这是构造方法");
    }

    public static void main(String[] args) {
//        new Test3();
//        new Test3();
    }

}
