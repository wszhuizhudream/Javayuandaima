package com.wschase.reflect1;

import javax.xml.stream.events.DTD;
import java.util.Date;

/**在反射只中反向创建对象是一个特别重要的知识点需要我们掌握
 * Author:WSChase
 * Created:2019/2/27
 */
public class TestReflect1 {
    public static void main(String[] args) {
        Date date=new Date();
        //1.Class对象的获取
        //(1)object.getClass
        Class classz1=date.getClass();
        System.out.println(classz1);

        //(2)ClassName.class
        Class<java.util.Date> dateClass=Date.class;
        //-->1)dateClass是Class对象
        System.out.println(dateClass);
        try{
            //2)下面这个操作才可以获得Date的对象，这样的方法就是反射的方法
            Date date2=dateClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //(3)Class.forName("className")
        Class<Date> dateClass1 = null;//声明对象
        try{
             dateClass1=(Class<Date>) Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("三个对象的比较：");
        System.out.println(classz1==dateClass1);
        System.out.println(classz1==dateClass);

    }

}
