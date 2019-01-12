package com.wschase.threadlesson1;

/**
 * Author:WSChase
 * Created:2019/1/10
 */

import java.util.DoubleSummaryStatistics;

/**
 * 编程题：
 * 要求：
 * （1）Person类有name，age，salary属性，要求实现至少两个构造方法，并且属性私有，提供对应的getter、setter。
 * （2）覆写toString方法
 * 要求在System.out.println()函数中传递Person对象能打印出三个属性值而不是对象地址。
 * （3）覆写equals方法，要求两个Person类对象的值同时返回true。
 */

class Person{
    private String name;
    private Integer age;
    private Double salary;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "姓名为："+this.name+"，年龄为："+this.age+",工资为："+this.salary;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }else if(!(obj instanceof Person)){
            return false;
        }else if(obj==this){//指向同一块空间
            return true;
        }
        Person per=(Person) obj;
        return this.name.equals(per.name)&&this.age.equals(per.age)&&this.salary.equals(per.salary);
    }
}
public class TestBasic {

    public static void main(String[] args) {

    Person p1=new Person("herry",18,1000.00001);
    Person p2=new Person("jack",19,1722.00001);
    Person p3=new Person("herry",18,1000.00001);
    Person p4=new Person("herry",20,1000.00001);
    //输出对象名，默认调用对象的toString()方法
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p4));
        System.out.println(p3.equals(p4));
        System.out.println(p2.equals(p3));
    }


}
