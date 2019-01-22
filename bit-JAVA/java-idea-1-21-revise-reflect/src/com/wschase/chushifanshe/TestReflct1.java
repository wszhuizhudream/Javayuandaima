package com.wschase.chushifanshe;

import java.util.Date;

/**初识反射：
 * 掌握正线创建对象、反向创建对象、Class对象的获取、Class类中实例化对象的方法
 * Author:WSChase
 * Created:2019/1/21
 */
public class TestReflct1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//    //1.对于Class类三种实例化对象方法：
      //(1)通过Object类中的getClass()方法取得Class类对象
//        System.out.println(date1.getClass());//这里就是反的本质——体现出了反射

      //(2)类.class：直接根据某个具体的类来取得Class类的实例化对象

//    //(3)Class.forName方法：在这个forName里面的是需要创建对象的类名
//    Class<?> c1=Class.forName("java.util.Date");//获取这个类名
//        System.out.println(c1.getName());


        //一般类的实例化对象：
//     //2.正向创建对象
//    Date date1=new Date();
//        System.out.println(date1);
//

//
//    //3.反向创建对象
       Class<?> c2=Class.forName("java.util.Date");
       Object obj=c2.newInstance();//此处相当于new java.util.Date();
        System.out.println(obj);




    }


}
