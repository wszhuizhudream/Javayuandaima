package com.wschase.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**集合与类之间的关系
 * Author:WSChase
 * Created:2019/1/15
 */

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

    //重写equals方法和 hashCode方法——它们两个一定要一起出现


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
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
public class ClassAndList {
    public static void main(String[] args) {
        //将集合中的泛型的类型指定为Person那么集合总要装入的元素就是Person类型的值
        List<Person> list=new ArrayList<>();
        list.add(new Person("张三",19));
        list.add(new Person("李四",19));
        list.add(new Person("张三",19));
        list.add(new Person("王五",20));

        //首先遍历集合将集合里面的元素输出:通过迭代器的方法遍历基金和中的元素并且输出
        System.out.println("第一次遍历集合元素：");
        Iterator<Person> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //下面检验经过覆写以后方法的效果是否和我们预期的效果一致
        System.out.println(list.contains(new Person("王五",20)));
        System.out.println(list.remove(new Person("李四",19)));//通过内容的比较，如果内容相同，那么就会将这个元素从集合中删除

        //通过集合里面的方法操作以后再次遍历集合将集合里面的元素遍历输出观察结果
        //注意：我们的迭代器在使用的时候，自己创建一个自己就是用，别人创建的不可以拿来使用
        System.out.println("经过一些列操作以后集合里面的元素：");
        Iterator<Person> iterator1=list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }

}
