package com.wschase.reflect;

import java.util.Date;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class TestClass {
    public static void main(String[] args) {

    //1.普通的一个对象，通过java.util.Date这个类实例化的
    Date date=new Date();

    //2.反向操作——反射
    Class classz=date.getClass();
        System.out.println(classz);


        //对象实例化
        //1.new 构造方法
        //2.反序列化
        //3.反射

        try {
            Date date1=(Date)classz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Class对象获取
        //1.object.getClass
        Class classz1=date.getClass();
        System.out.println(classz1);
        //2.ClassName.class
        //建议：一般在开发反射的代码中我们经常使用类的权限名
        Class<java.util.Date> dateClass=Date.class;
        System.out.println(dateClass);
        try {
            Date date2 = dateClass.newInstance();
            System.out.println(date2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //3.Class.forName("className");

        Class dateClass2 ;
        try {
            Class<Date> dateClass1= (Class<Date>) Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {
            //注意：这里的异常
            e.printStackTrace();
        }

        //当前这三个Class对象都是由Class<java.util.Date>获取，都来描述java.util.Date这个类
        System.out.println("比较三个Class对象");
        System.out.println(classz==dateClass);
        //System.out.println(classz==dateClass);

        //Class这个类是描述我们在java中定义的类
        //Class类的对象是Class文件加载到JVM中的标识对象（类加载器）

    }
}
