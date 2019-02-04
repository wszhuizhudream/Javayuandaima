package com.wschase.object2;

/**代码块：在java笔试面试中都特别的重要
 * Author:WSChase
 * Created:2019/2/4
 */

class Person{

    static {
        System.out.println("这是Person的静态块");
    }

    {
        System.out.println("这是Person的构造块");
    }

    public Person(){
        System.out.println("这是Person的构造方法");
    }
}
public class TestCode {
    public static void main(String[] args) {
//        new Person();
//        new Person();
    }
}
