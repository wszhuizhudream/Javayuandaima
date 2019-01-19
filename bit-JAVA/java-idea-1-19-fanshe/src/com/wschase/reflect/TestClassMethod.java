package com.wschase.reflect;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class TestClassMethod {
    public static void main(String[] args) {
        //1.获取Class对象所描述的类的包
        //2.获取Class对象所描述的类的继承的类
        //3.获取Class对象所描述的类的实现接口

        try {
            Class<Test> testClass= (Class<Test>) Class.forName("com.wschase.reflect.Test");

            Package aPackage=testClass.getPackage();
            //1.获取Class对象所描述的类的包
            System.out.println("打印包名：");
            System.out.println(aPackage.getName());//包名

            Class superclass=testClass.getSuperclass();
            //2.获取Class对象所描述的类的继承的类
            System.out.println("打印父类toString()");
            System.out.println(superclass);


            System.out.println("打印父类SimpleName："+superclass.getSimpleName());
            System.out.println("打印父类Name："+superclass.getName());

            //3.获取Class对象所描述的类的实现接口
            Class[] classes=testClass.getInterfaces();
            System.out.println("打印实现的接口");
            for(Class c:classes){
                System.out.println(c);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

interface IMessage{

}
interface IFruit1{

}

//extends Object
class Test implements IMessage,IFruit1{

}
