package com.wschase.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**AbstractList抽象类实现子类——LinkedList
 * 下面讲一下List的实现子类LinkedList的实例化对象的实现、集合中元素的遍历、常用的操作方法
 * Author:WSChase
 * Created:2019/1/15
 */
class Person1{
    private String name;

    private Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return Objects.equals(name, person1.name) &&
                Objects.equals(age, person1.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestLinkedList {
    //在操作方法上，LinkedList和ArrayList是一样的
    //我们就举一个简单的例子
    public static void main(String[] args) {
        List<Person1> list=new LinkedList<>();//实现向上转型

        list.add(new Person1("李四",20));
        list.add(new Person1("李四",20));
        list.add(new Person1("张三",19));

        //注意：要遍历集合里面的元素首先们需要保证已经将元素放进去了的，集合里面如果没有元素自然也就遍历不到，因为集合为空
        System.out.println("第一次遍历集合元素：");
        Iterator<Person1> iterator=list.iterator();
        while (iterator.hasNext()){//它为真表明里面还有元素
            System.out.println(iterator.next());
        }

        System.out.println(list.contains(new Person1("张三",19)));
        System.out.println("删除的元素是：");
        System.out.println(list.remove(2));

        //经过一系列操作以后再次遍历集合输出元素
        System.out.println("经过一系列操作以后集合里面的元素：");
        Iterator<Person1> iterator1=list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
