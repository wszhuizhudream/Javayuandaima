package com.wschase.javase.revise1.inner;

/**将外部类的属性改为静态属性那么就可以在静态内部类中访问外部类的属性
 * Author:WSChase
 * Created:2019/3/15
 */
public class Test4 {
    private static String msg = "这是外部类的静态私有属性";

    public String getMsg() {
        return msg;
    }

    static class Inner {
        public Inner() {
            System.out.println("这是静态内部类的构造方法");
        }

        public void print() {
            //在静态内部类中不可以访问外部类的非静态属性和非静态方法
            //现在将外部类中私有属性改为了静态属性，那么在静态内部类中就可以访问
            System.out.println("这是静态内部类的方法");
            System.out.println(msg);//相当于是Outter.this.msg
        }
    }


    //外部类的方法
    public void fun() {
        //在外部类创建静态内部类的对象，不依赖外部类创建的对象
        Test4.Inner inner = new Test4.Inner();
        inner.print();

    }


    public static void main(String[] args) {
        Test4 test4=new Test4();
        test4.fun();

    }
}
