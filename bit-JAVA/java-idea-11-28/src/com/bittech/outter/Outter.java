package com.bittech.outter;

/**
 * Author:WSChase
 * Created:2018/11/28
 */
public class Outter {
    private String msg ="这是外部类的属性";
    public void print(){
        System.out.println("这是外部类的方法");


    }
    class Inner{
        public Inner(){
            System.out.println("这是内部类的构造方法");
        }
        public void fun(){
            System.out.println(msg);
            Inner inner1=new Inner();
            Outter.this.print();
        }
    }

    public static void main(String[] args) {
        Outter.Inner inner2=new Outter().new Inner();
        inner2.fun();

    }
}
