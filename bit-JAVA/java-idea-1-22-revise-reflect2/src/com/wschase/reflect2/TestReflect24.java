package com.wschase.reflect2;

import java.lang.reflect.Field;

/**2.4反射调用类中属性
 * Author:WSChase
 * Created:2019/1/23
 */

class Person2{
    public String name;

    private int age;
}

class Student extends Person{
    public String school;
}
public class TestReflect24 {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> cls2=Class.forName("com.wschase.reflect2.Student");
        {
            //普通代码块
            //第一组：取得本类中公有属性
            Field[] fields=cls2.getFields();
            for(Field field:fields){
                System.out.println(field);
            }
        }

        System.out.println("---------------------");
        {

            //第二组：取得本类中全部属性
            Field[] fields=cls2.getDeclaredFields();
            for(Field field:fields){
                System.out.println(field);
            }
        }

    }



}
