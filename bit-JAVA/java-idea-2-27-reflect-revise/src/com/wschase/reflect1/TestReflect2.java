package com.wschase.reflect1;

import java.lang.reflect.Constructor;

/**反射调用构造
 * Author:WSChase
 * Created:2019/2/27
 */
public class TestReflect2 {
    public static void main(String[] args) {
        try{
            Class classz=Class.forName("com.wschase.reflect1.Person");

            //1.构造方法
            Constructor[] constructors=classz.getConstructors();
            System.out.println("打印输出Person类的构造方法：");
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
            System.out.println("打印输出Person类的一个参数的构造方法：");
            System.out.println(classz.getConstructor(java.lang.String.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class Person{
    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}