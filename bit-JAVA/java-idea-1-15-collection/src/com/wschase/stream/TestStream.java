package com.wschase.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Collection改进
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestStream {
    public static void main(String[] args) {
//        //1.forEach()方法的使用
//        List<String> list=new ArrayList<>();
//        list.add("A");
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.forEach(System.out::println);
//
////        //2.Stream数据流对象
//        Stream<String> stream=list.stream();
////        System.out.println(stream.count());
////        stream.close();
//
//        //3.Stream操作——注意：Stream流与之前学的数据流是一样的，当进行完读或取以后需要将Steam流关闭
//
//        //（1）数据过滤
//      //  System.out.println(stream.filter((e)->e.contains("A")).count());
//
//        //（2）收集器
//        //收集过滤后的数据——收集完以后的数据依然属于List集合，所以直接用List进行接收
//        List<String> result=stream.filter((e)->e.contains("A")).collect(Collectors.toList());
//        System.out.println(result);
//        stream.close();

        //3.使用skip与limit方法
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"a","a","b","c");

        //实例化Stream对象
        Stream<String> stream=list.stream();
        List<String> result=stream.skip(0).limit(3)
                .map((s)->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(result);

    }
}
