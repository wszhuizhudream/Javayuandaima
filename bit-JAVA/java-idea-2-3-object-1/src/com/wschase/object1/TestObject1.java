package com.wschase.object1;

/**面向对象——三大特性（this关键字）
 * 对于this关键字我们主要讨论它的三个特点：
 * 1.this调用本类属性
 * 2.this调用本类方法
 * 3.this表示当前对象
 * Author:WSChase
 * Created:2019/2/3
 */

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getPersonInfo(){
        return "姓名："+name+",年龄："+age;
    }
}
public class TestObject1 {

    public static void main(String[] args) {
               Person p1=new Person("张三",20);
        System.out.println(p1.getPersonInfo());
    }

}
