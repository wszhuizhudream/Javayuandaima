package com.bittech.reflect;

/**
 * Author: secondriver
 * Created: 2019/1/17
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestClassMethod {
    
    public static void main(String[] args) {
        //1.获取Class对象所描述的类的包
        //2.获取Class对象所描述的类的继承的类
        //3.获取Class对象所描述的类的实现的接口
        
        try {
            Class testClass = Class.forName("com.bittech.reflect.Test");
            Package packageObj = testClass.getPackage();
            System.out.println("打印包名：");
            System.out.println(packageObj.getName());//包名
            
            Class supperClass = testClass.getSuperclass();
            System.out.println("打印父类toString()");
            System.out.println(supperClass);
            System.out.println("打印父类SimpleName：" + supperClass.getSimpleName());
            System.out.println("打印父类Name：" + supperClass.getName());
            
            
            Class[] classes = testClass.getInterfaces();
            System.out.println("打印实现的接口：");
            for (Class c : classes) {
                System.out.println(c);
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
}

interface IMessage {

}

interface IFruit {

}

///extends Object
class Test extends TestClassMethod implements IMessage, IFruit {

}
