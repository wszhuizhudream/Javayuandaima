package com.wschase.map;

import java.util.*;

/**Map接口的实现子类——HashMap
 * Collection集合里面存放元素是单个的；
 * 1.Map集合的特点：
 * （1）Map集合里面存储元素都是成对的；
 * （2）并且这两个对象的关系：key=value结构；
 * （3）可以通过key找到对应的value内容
 * 2.在Map集合里面我们一般是使用梓潼类Integer、String等作为key，但是也是可以用
 * 用户自定义的类作为key的，这个时候一定要记得覆写Object类的hashCode和equals()方法。
 * 下面将介绍HashMap的基本操作
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestHashMap {
    public static void main(String[] args) {

        //1.创建HashMap集合并存放元素
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(1,"Hello");
        map.put(3,"nihao");
        map.put(2,"world");

        //2.Map的常见操作方法
        //（1）取得Map中所有的key信息：自动去除重复的key值

        //1）这个表示取得map这个集合的所有key信息
        Set<Integer> set=map.keySet();

        Iterator<Integer> iterator=set.iterator();//map的所有key的迭代器
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //（2）取得Map的所有value信息：可以取得重复的value信息，但是对于key重复的元素只取最后一个元素

        //1）取得map集合的所有value
        Collection<String> collection=map.values();
        Iterator<String> iterator1=collection.iterator();
        while (iterator1.hasNext()) {//下一个元素不为空
            System.out.println(iterator1.next());
        }

        //（3）通过key取得value的结果：
            // 1）如果有value那么直接返回对应的value
            // 2）如果没有直接返回null
            // 3）如果key相同，则取得的是最后一个key的value
            System.out.println("通过key获得value");
            System.out.println(map.get(1));


            System.out.println("---------------------");
        //(4)Map集合使用Iterator输出（重点）
        //在Map中本身是没有iterator()方法的，但是Map集合可以转换为Set集合
        //而Set集合有迭代器iterator，所以要想使用迭代器输出Map集合里面的内容
        //需要先将Map集合转化为Set集合
        //1)将Map集合转化为Set集合
            Set<Map.Entry<Integer,String>> set1=map.entrySet();

        //2)获取Iterator对象
            Iterator<Map.Entry<Integer, String>> iterator2=set1.iterator();

        //3)输出
        while (iterator2.hasNext()){
            //4)取出每一个Map.Entry对象——通过转化为set集合输出集合里面的元素值也是按照键值对的形式输出的
            Map.Entry<Integer,String> entry=iterator2.next();
            System.out.println(entry);

//            //5)取得key和value
//            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }

}
