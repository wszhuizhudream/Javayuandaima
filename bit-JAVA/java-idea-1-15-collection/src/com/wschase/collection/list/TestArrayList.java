package com.wschase.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**AbstractList抽象类实现子类——ArrayList
 * 下面讲一下List的实现子类ArrayList的实例化对象的实现、集合中元素的遍历、常用的操作方法
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestArrayList {

    public static void main(String[] args) {

    //1.实例化集合的一个对象，并且将元素放入

    List<String> list1=new ArrayList<>();
    list1.add("hello");
    list1.add("world");
    list1.add("Hello");
    list1.add("hello");
    list1.add("nihao");

    //2.集合中元素的遍历
        //(1)通过for循环
        System.out.println("通过for循环遍历集合元素");
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));//这里的i相当于是集合里面元素的索引
        }

        //(2)通过foreach循环
        System.out.println("通过foreach循环遍历集合元素");
        for(String alist1:list1){
            System.out.println(alist1);//直接将元素输出
        }

        //(3)通过迭代器输出
        System.out.println("通过迭代器遍历集合元素");
        Iterator<String> iterator=list1.iterator();//将需要遍历的集合的迭代器传递给新创建的迭代器
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //(4)双向迭代接口：ListIterator
        //首先我们应该知道ListIterator是Iterator接口的子接口
        //对于ListIterator接口它既可以进行向前操作又可以进行向后操作
        //下面我们来看它的两个功能
        //1)判断是否有上一个元素：public boolean hasPrevious()
        ListIterator<String> listIterator=list1.listIterator();
        System.out.println("从前向后输出：");
        while (listIterator.hasNext()){
            System.out.println(listIterator.next()+"、");//输出的是后一个元素
        }

        //但是在这需要注意：如果要实现从后向前输出，那么我们需要先从前向后输出，这样集合在遍历的时候，从后向前才有元素
        System.out.println("\n从后向前输出：");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous()+"、");//输出的是前一个元素
        }

        //2)取得上一个元素：public E previous()








    //3.常见的操作方法
        //（1）判断是否有包含这个元素，结果返回boolean型
        System.out.println(list1.contains("hello" ));

        //（2）通过索引获得当前索引的元素
        System.out.println(list1.get(1));

        //（3）判断当前索引是多少
        System.out.println(list1.indexOf("world"));

        //（4）当前集合元素长度
        System.out.println(list1.size());

        //（5）在相同的元素中取最后一个元素的索引
        System.out.println(list1.lastIndexOf("hello"));

        //（6）按照索引删除，删除后会返回当前索引对应的元素
        System.out.println(list1.remove(3));

        //（7）按照元素删除，结果返回boolean类型
        System.out.println(list1.remove("nihao"));
        System.out.println(list1.remove("bit"));
    }

}
