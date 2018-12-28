package com.bittech.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Author: secondriver
 * Created: 2018/12/11
 */
public class TestList {
    
    //List -> ArrayList基本使用
    public static void code1() {
        //实例化一个ArrayList对象 ，List类型
        List<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("C");
        list1.add("C++");
        list1.add("Python");
        list1.add("PHP");
        list1.add("Java");//List可以重复元素
        /*
        System.out.println(list1);
        
        list1.add(0, "Go");
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
//        list1.addAll(list1);
//        System.out.println(list1);
        System.out.println(list1.remove("Java"));
        System.out.println(list1.remove("Groovy"));
        System.out.println(list1);
        System.out.println(list1.remove(0));
        System.out.println(list1);
        */
        
        //for
//        System.out.print("[");
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i));
//            if (i < list1.size() - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");

//        System.out.print("[");
//        for (int i = 0, len = list1.size(); i < len; i++) {
//            System.out.print(list1.get(i));
//            if (i < len - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");

//        System.out.print("[");
//        for (String item : list1) {
//            System.out.print(item);
//            System.out.print(", ");
//        }
//        System.out.println("]");
        
        //迭代器接口
//        Iterator<String> iterator = list1.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//            System.out.print(",");
//        }
        
        //Object[] elementArray = list1.toArray();
//        String[] elementArray = new String[list1.size()];
//        for (int i = 0, len = list1.size(); i < len; i++) {
//            elementArray[i] = list1.get(i);
//        }
        
        String[] elementArray = new String[list1.size()];
        list1.toArray(elementArray);
        System.out.println(Arrays.toString(elementArray));
        
        //不直接使用Collection接口
//        Collection collection = list1;
//        collection.toArray()
    }
    
    public static void code2() {
        List<Person> people = new ArrayList<>();
        Person jack = new Person("Jack", 22);
        people.add(jack);
        people.add(new Person("Alice", 18));
        people.add(new Person("Alex", 23));
        for (Person p : people) {
            System.out.println(p);
        }
        
        System.out.println(people.contains(new Person("Jack", 24)));
//        System.out.println(people.contains(jack));
//        System.out.println(people.remove(jack));
    }
    
    
    public static void code3() {
        //Map<K,V>
        Person jack = new Person("Jack", 22);
//        Person tom = new Person("Tom", 23);
//        System.out.println(jack.equals(tom));
//        System.out.println(jack.hashCode());
//        System.out.println(tom.hashCode());
        Person jack2 = new Person("Jack", 22);
        System.out.println(jack.equals(jack2));//equals 覆写比内容，
        System.out.println(jack.hashCode() == jack2.hashCode());
    }
    
    public static void code4() {
        //Vector
        List<String> vector = new Vector<>();
        vector.add("jack");
        vector.add("C++");
//        System.out.println(vector);
        
        //Old API
        Enumeration<String> enumeration = ((Vector<String>) vector).elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
    
    
    public static void code5() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
//            iterator.add("+");
//            iterator.set("+"); //error
            System.out.print(iterator.next() + ", ");
//            iterator.add("+");
            iterator.set("+");
        }
//        System.out.println();
//        for (String item : list) {
//            System.out.print(item + ", ");
//        }


//        for (int i = 0, len = list.size(); i < len; i++) {
//            System.out.println(list.get(i));
//            //list.remove("Java");
//        }
    
    }
    
    public static void main(String[] args) {
        //数据结构：List ->  ArrayList
        //1.ArrayList的数据是通过数组存放
        //2.ArrayList的默认构造方法实例化，存储数据的数组初始化时在第一次添加元素时进行(lazy load) -扩容-50% -默认容量10
        //3.ArrayLis的初始化容量的构造方法实例化，存储数据的数组立即初始化
        List<String> list = new ArrayList<>();
    }
}

class Person {
    
    private String name;
    private Integer age;
    
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    //手工写的
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof Person) {
//            Person that = (Person) obj;
//            return this.getName().equals(that.getName())
//                    &&
//                    this.getAge().equals(that.getAge());
//        }
//        return false;
//    }
    
    //1. equals 和 hashCode 方法覆写一定要一起使用
    //2. equals参与判断的属性都要参与hashCode的计算
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Person person = (Person) o;
        
        if (!name.equals(person.name)) return false;
        return age.equals(person.age);
    }
    
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}
