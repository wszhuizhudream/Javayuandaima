package com.wschase.javase.revise1.inner;

/**
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test2 {
    private String msg="这是外部类的私有属性";
    class Inner{
        public Inner(){
            System.out.println("这是成员内部类的构造方法");
        }

        public void print(){
            System.out.println("这是成员内部类");
            System.out.println(msg);
        }

        public void fun(){
            Inner in=new Inner();
        }
    }

    public static void main(String[] args) {
        //成员内部类的类名：外部类.内部类
        Test2.Inner inner=new Test2().new Inner();
        inner.print();



    }
}
