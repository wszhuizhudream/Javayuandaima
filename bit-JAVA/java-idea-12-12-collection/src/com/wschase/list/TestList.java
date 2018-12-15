package com.wschase.list;

import java.util.*;

/**List的间接子类：ArrayList
 * Author:WSChase
 * Created:2018/12/12
 */
//code2代码：
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

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//记住：hashCode和equals要同时出现
    //将equals方法覆写是为了后面子在使用集合中的contains()、remove()方法的时候可以直接进行内容的比较，或者直接移除内容，而不是地址
    //注意：集合里面使用的都是引用数据类型，所以都会涉及到我们的栈上面是地址，堆上面是内容。
    //（1）我们自己覆写equals方法
//    @Override
//    public boolean equals(Object obj) {
//        if(super.equals(obj)){
//            return true;
//        }else{
//            if(obj==null){
//                return false;
//            }
//            if(obj instanceof Person){
//                Person that=(Person) obj;
//             return  this.getName().equals(that.getName())
//                        &&this.getAge().equals(that.getAge());
//            }else {
//                return false;
//            }
//        }
//
//    }

//    //分开生成代码：
//    //（2）直接用代码生成覆写equals方法
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) &&
//                Objects.equals(age, person.age);
//    }
//
////覆写hashCode-》直接通过代码生成
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name, age);
//    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



public class TestList {

    public static void code1(){
        //如何实例化集合的一个对象，并放入元素
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("world");
        list1.add("！！");
        list1.add("hello");


//1.集合中元素的遍历
        //List接口里面的元素是可以重复的
//        System.out.println(list1.size());
        //(1)for循环
//        for(int i=0;i<list1.size();i++){
//            System.out.println(list1.get(i));
        //(2)foreach循环-->推荐使用
//            for (String aList1 : list1) {
//                System.out.println(aList1);
        //(3)迭代器遍历集合
//        Iterator<String> iterator = list1.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());

//2.ArrayList类中的常用方法
        //判断是否有包含这个元素，返回的类型是boolean
        System.out.println(list1.contains("hello"));//true
        System.out.println(list1.contains("Hello"));//false
        //通过索引获得当前索引的元素值
        System.out.println(list1.get(0));//hello
        //判断当前元素的索引是多少，如果没有当前元素返回的是-1
        System.out.println(list1.indexOf("hello"));//-1，没有的就是返回的-1
        //当前集合中元素的长度
        System.out.println(list1.size());//4
        //在相同的元素中取最后一个元素的索引
        System.out.println(list1.lastIndexOf("hello"));//4
        //按照索引删除，删除以后返回的是删除的当前索引的那个元素
        System.out.println(list1.remove(1));//world
        System.out.println(list1.size());//3
        //按照元素删除如果没有这个元素返回的就是false
        System.out.println(list1.remove("Hello"));//false，由于元素里面没有Hello这个字符串，所以返回false
    }

    public static void code2(){
        List<Person> people=new ArrayList<>();
        people.add(new Person("张三",10));
        people.add(new Person("王五",11));
        people.add(new Person("李四",12));
        //在集合中contains()、remove()方法是依赖的equals()来实现的
        people.remove(new Person("李四",12));
        System.out.println(people.contains(new Person("王五",11)));
        for(Person p:people){
            System.out.println(p);
        }

    }
    public static void code3(){
        //ArrayList []固定 ，扩容
        //LinkedList  链表
        List<Person> people=new LinkedList<>();
        people.add(new Person("jack",22));
        people.add(new Person("Tom",23));
        //默认的添加是往后加
        ((LinkedList<Person>) people).addFirst(new Person("Alice",18));
        ((LinkedList<Person>) people).addLast(new Person("Alex",19));
        for(Person p:people){
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        //ArrayList源代码：
//        /**
//         * Default initial capacity.（默认容量）
//         */
//        private static final int DEFAULT_CAPACITY = 10;
//
//        /**
//         * Shared empty array instance used for empty instances.（共享空数组）
//         */
//        private static final Object[] EMPTY_ELEMENTDATA = {};
//
//        /**
//         * Shared empty array instance used for default sized empty instances. We
//         * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
//         * first element is added.
//         */
//        private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//        /**
//         * The size of the ArrayList (the number of elements it contains).
//         *
//         * @serial
//         */
//        private int size;



        //数据结构：List -> ArrayList
        //1.ArrayList的数据是通过数组存放的
        //2.ArrayList的默认构造方法实例化，存储数据的数组初始化是在第一次添加元素的时候进行初始化（Lazy lode）-》延迟添加，可以节约内存
        // ->扩容->一般是扩容50%，默认容量是10（面试的时候爱问）
        //3.ArrayList的初始化容量（这个构造方法的参数是初始化容量）的构造方法实例化，存储数据的数组立即初始化
        List<String> list=new ArrayList<>();
        }
}
