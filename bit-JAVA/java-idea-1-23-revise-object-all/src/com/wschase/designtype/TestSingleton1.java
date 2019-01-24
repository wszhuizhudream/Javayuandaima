package com.wschase.designtype;

/**2.1单例设计模式（特别重要）
 * 单例设计模式就是：一个类只能产生一个实例化对象
 * Author:WSChase
 * Created:2019/1/23
 */
class Singleton{
    public void print(){
        System.out.println("hello world");
    }
}
public class TestSingleton1 {
    public static void main(String[] args) {
        Singleton singleton=null;//声明对象
        singleton=new Singleton();//实例化对象
        singleton.print();
    }
}
