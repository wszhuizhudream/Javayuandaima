package com.wschase.javase.revise1.inner;

/**方法内部类：在方法内部类中，它于成员内部类相似，唯一的区别就是它的作用范围仅仅在一个方法内
 * Author:WSChase
 * Created:2019/3/15
 */
class Outter{
    private String msg="这是外部类的私有属性";

    public void print(int num){
        //这是外部类的一个方法，下面将内部类定义在这个方法中，所以它叫做方法内部类
        class Inner{
            public void fun(){
                System.out.println("这是一个方法内部类");
                System.out.println(msg);
                System.out.println(num);
            }
        }


        //在外部方法中创建内部类的对象
        Inner in=new Inner();
        in.fun();
        }
    }
public class Test5 {
    public static void main(String[] args) {
        Outter outter=new Outter();
        outter.print(20);
    }
}
