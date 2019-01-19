package com.wschase.reflect;

import jdk.internal.org.objectweb.asm.commons.Method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:WSChase
 * Created:2019/1/19
 */
public class TestClassConstructor {

    //Constructor
    public static void code1(){

        try {
            Class classz=Class.forName("com.wschase.reflect.Person");
            //1.构造方法
            Constructor[] constructors=classz.getConstructors();
            System.out.println("打印输出Person类的构造方法：");
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
            System.out.println("打印输出Person类的一个参数的构造方法：");
            System.out.println(classz.getConstructor(java.lang.String.class));
            //2.（1）class.newInstance =>类里面有无参数构造方法
            Person p= (Person) classz.newInstance();
            System.out.println(p);
            //（2）Person(String name)-》有参构造方法
            //Constructor =>获取构造方法对象，执行构造方法对象的newInstance(参数值...)
            System.out.println("通过构造方法来获取对象");
            Constructor constructor=classz.getConstructor(java.lang.String.class);
            //constructor.newInstance
            Person p1=(Person) constructor.newInstance("张三");
            System.out.println(p1);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

//    public static void code2() {
        //1.获取Person类中所有普通方法
//              Method[] methods=clases.getMethod();
//              for(Method m:methods){
//                  System.out.println(m);
//              }


//        //2.获取Person类中的setName方法
//        java.lang.reflect.Method setNameMethod = clases.getMethod("setName", String.class);
//
//        //3.调用方法
//        Person person = (Person) clases.newInstance();
//        Object voidObject = setNameMethod.invoke(person, "霓虹");
//        System.out.println("setName=" + voidObject);
//        System.out.println(person);
//        java.lang.reflect.Method getNameMethod = clases.getMethod("getName");
//        Object stringObject = getNameMethod.invoke(person);
//        System.out.println("getName=" + stringObject);
//        System.out.println(voidObject);
//    }




    public static void main(String[] args) {
          try{
              Class clases=Class.forName("com.wschase.reflect.Student");

              //获取属性：public
              Field[] fields=clases.getFields();
              System.out.println("输出所有的公开的属性：");
              for(Field f:fields){
                  System.out.println(f);
              }

              System.out.println("输出本类所有的声明的属性");
              for(Field f:clases.getDeclaredFields()){
                  System.out.println(f);
              }

              System.out.println("获取指定属性");
              Field major=clases.getDeclaredField("major");
              System.out.println(major);


              //Student一个对象
              Student student=(Student) clases.newInstance();
              System.out.println("实例化后的信息："+student);
              major.setAccessible(true);//是字段——通过强制访问私有属性
              major.set(student,"计算机");
              System.out.println("通过major Fild赋值之后："+student);
              Object value=major.get(student);
              System.out.println("通过major Filed获取值："+value);

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
        e.printStackTrace();
        }


    }

}

class Person{
    public String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
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

class Student extends Person{
    public String teacher;

    private String major;

    public String getTeacher() {
        return teacher;
    }

    public String getMajor() {
        return major;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
