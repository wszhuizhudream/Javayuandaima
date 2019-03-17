package com.wschase.javase.revise1.inner;

/**内部类
 * Author:WSChase
 * Created:2019/3/15
 */
//1.成员内部类：成员内部类就像普通内部类，在它的里面可以出现任何由static修饰的属性或者方法
public class Test1 {
    private String msg="这是外部类的属性";

    class Inner{
        public Inner(){
            System.out.println("这是成员内部类的构造方法");
            System.out.println("在成员内部类里面访问外部类的属性："+msg);
        }

        public void fun(){
            Inner in=new Inner();
        }
    }

    public static void main(String[] args) {
        //非静态内部类对象的创建必须依赖于外部类对象的创建，必须得外部类创建完对象
        //以后，非静态内部类才可以创建对象。而成员内部类属于非静态内部类，所以它
        //遵守非静态内部类创建对象的规则。
        Test1.Inner inner=new Test1().new Inner();
    }
}
