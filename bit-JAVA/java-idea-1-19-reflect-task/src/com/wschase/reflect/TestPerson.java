package com.wschase.reflect;

/**工具类
 * Author:WSChase
 * Created:2019/1/19
 */
public class TestPerson {
    public static void main(String[] args) {
        Person p1=new Person();//创建对象1
        p1.setEname("张三");
        p1.setAge(23);
        p1.setBirthday("1995-2-28");
        System.out.println(p1);

        Person p2=new Person();//创建对象2
    }

//    //在这个类里面编写一个工具方法，可以进行功能的实现
//    public static Person BeanCopy(Person p1,Person p2){
//        //再写一个工具类提供一个方法：当传入两个对象（a、b）的时候，将A里面属性的值全面拷贝到b里面去
//
//    }
}
