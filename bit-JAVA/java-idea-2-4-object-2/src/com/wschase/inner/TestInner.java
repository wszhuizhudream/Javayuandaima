package com.wschase.inner;

/**内部类:
 * Author:WSChase
 * Created:2019/2/4
 */
class Outer1{
    private String msg="外部类的属性";

    //下面定义一个内部类
    class Inner{
        public void print(){
            System.out.println(msg);
        }
    }

    //在外部类中定义一个方法，该方法负责产生内部类对象并且调用内部类的print方法
    public void fun(){
        Inner in=new Inner();
        in.print();
    }
}
public class TestInner {
    public static void main(String[] args) {
        Outer1 out=new Outer1();
        out.fun();
    }
}
