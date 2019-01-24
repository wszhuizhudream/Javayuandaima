package com.wschase.reflect2;

import java.lang.reflect.Constructor;

/**2.2反射调用构造
 * Author:WSChase
 * Created:2019/1/22
 */

class Person{
    private String name;

    private int age;

    public Person() {
    }

    public Person(String name){}

    public Person(String name,int age){}


}

public class TestReflect22 {
    public static void main(String[] args) {
        Class<?> cl=Person.class;

        //取得类中的全部构造
        Constructor<?>[] constructors=cl.getConstructors();
        for(Constructor<?> c:constructors){
            System.out.println(c);
        }

    }
}
