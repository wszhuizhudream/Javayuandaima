package com.wschase.collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**AbstractSet抽象类的现子类——TreeSet（自动排序）
 * 下面讲一下Set的间接实现子类TreeSet的实例化对象的实现、集合中元素的遍历、常用的操作方法
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<String> set=new TreeSet<>();
        set.add("A");
        set.add("B");
        set.add("c");
        set.add("C");
        set.add("d");
        set.add("E");

        //将集合中的元素输出观察它的有序排列情况
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
