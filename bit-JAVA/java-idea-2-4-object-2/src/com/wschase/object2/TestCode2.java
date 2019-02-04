package com.wschase.object2;

/**在主类中的静态代码块
 * Author:WSChase
 * Created:2019/2/4
 */
public class TestCode2 {

    static {
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是构造块");
    }

    public TestCode2(){
        System.out.println("这是构造方法");
    }

    public static void main(String[] args) {

    }
}
