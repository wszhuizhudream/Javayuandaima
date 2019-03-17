package com.wschase.javase.revise1.inner;

/**静态内部类
 * Author:WSChase
 * Created:2019/3/15
 */
//情况1：静态内部类不可以访问外部类的非静态属性
public class Test3 {
    private String msg="这是外部类的已有属性";

    public String getMsg(){
        return msg;
    }

    //静态内部类
    static class Inner{
        public Inner(){
            System.out.println("这是静态内部类的构造方法");
        }

        public void print(){
            //在静态内部类中不可以访问外部类的非静态属性和非静态方法
            System.out.println("这是静态内部类");
        }
    }


    //这是外部类的方法
    public void fun(){
        //在外部类创建静态内部类对象，不依赖外部类创建的对象
        //静态内部类的类名：外部类.内部类
        Test3.Inner inner=new Test3.Inner();
        inner.print();
    }

    public static void main(String[] args) {
        //创建一个外部类的对象
        Test3 test3=new Test3();
        test3.fun();
    }
}
