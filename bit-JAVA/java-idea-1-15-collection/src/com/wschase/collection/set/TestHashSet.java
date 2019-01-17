package com.wschase.collection.set;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**AbstractSet抽象类的现子类——HashSet(无序)
 * 下面讲一下Set的间接实现子类HashSet的实例化对象的实现、集合中元素的遍历、常用的操作方法
 * 我们一定要注意：在Set集合里面是不可以放入重复元素的
 * 当我们放入重复元素以后集合自动的将重复元素删除，遍历集合元素输出后是没有重复元素的
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestHashSet {
    public static void main(String[] args) {
        //1.实例化对象，并将元素存入集合
        Set<String> set=new HashSet<>();
        //往集合中添加元素
        set.add("hello");
        set.add("bit");
        set.add("hello");//error——集合自动删除
        set.add("java");


        //2.集合中元素的遍历
        //同样有3中方法，下面我们使用两种：foreach循环和迭代器
        //(1)foreach循环
        for (String hset:set) {
            System.out.println(hset);
        }

        //(2)迭代器
        Iterator<String> iterator=set.iterator();//将set集合的迭代器赋值给一个迭代器
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //3.常用的操作方法
        System.out.println(set.contains("hello"));
        System.out.println(set.size());



    }
}
