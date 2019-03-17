package com.wschase.javase.revise1.inner;

/**匿名内部类：定义在方法中没有名字的内部类
 * 注意：匿名内部类必须首先一个接口或者继承一个抽象类
 * Author:WSChase
 * Created:2019/3/15
 */
interface MyInterface{
    void test();
}
public class Test6 {
    private String msg="这是外部类的私有属性";
    public void print(int num){
        new MyInterface(){

            @Override
            public void test() {
                System.out.println("这是一个匿名内部类");
                System.out.println(msg);
                System.out.println(num);
            }
            //因为是匿名内部类，没有名字。所以不可以创建对象，只能直接调用内部类
        }.test();
    }

    public static void main(String[] args) {
        Test6 test6=new Test6();
        test6.print(20);
    }

}
