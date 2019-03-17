package com.wschase.javase.revise1.object;

/**构造块
 * Author:WSChase
 * Created:2019/3/15
 */
public class Person {
    {
        //构造块的定义：定义在类中不加任何的修饰符
        System.out.println("这是person的构造块");
    }

    public Person(){
        System.out.println("这是Person的构造方法");
    }


    public static void main(String[] args) {
        //我们观察构造方法的执行次数以及构造块的执行次数
        //当我们创建一个对象的时候：下执行它的构造块、然后执行它的构造方法
        //并且这个的顺序是固定的，执行完构造块再执行构造方法。
        new Person();
        new Person();
    }
}
