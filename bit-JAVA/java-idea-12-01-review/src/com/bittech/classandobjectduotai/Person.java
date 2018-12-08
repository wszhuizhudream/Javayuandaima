package com.bittech.classandobjectduotai;

/**
 * Author:WSChase
 * Created:2018/12/3
 */
public class Person {
    private String name;
    private int age;
    //构造方法
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //封装
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void fun(){
        System.out.println("这是父类的方法");
    }
    public String print(){
        return "name:"+this.name+",age:"+this.age;
    }
}
