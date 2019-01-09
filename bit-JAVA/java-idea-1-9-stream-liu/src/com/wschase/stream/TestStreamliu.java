package com.wschase.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Stream流
 * Author:WSChase
 * Created:2019/1/9
 */
public class TestStreamliu {
    public static void main(String[] args) {
        //1.Collection改进
//        //forEach 来自 Iterator
//        //Stream  来自 Collection
//        List<String> list=new ArrayList<>();
//        Collections.addAll(list,"java","C++","Pathon");
//        //(1)
////        list.forEach(new Consumer<String>() {
////            @Override
////            public void accept(String s) {
////                System.out.println(s);
////            }
////        });
//        //(2)lambda表达式
//        list.forEach(s-> System.out.println(s));
//        //（3）foreach循环
//        list.forEach(System.out::println);


        //2.Stream操作
//        //（1）数据过滤
//        List<String> list=new ArrayList<>();
//        Collections.addAll(list,"java","C++","php","javaScript");
//        //实例化Stream对象
//        Stream<String> stream=list.stream();
//        //统计出这些数据中带有java的个数
//        System.out.println(stream.filter((e)->e.contains("java")).count());


        //(2)收集器
//        List<String> list=new ArrayList<>();
//        Collections.addAll(list,"java","C++","php","javaScript");
//        //实例化stream对象
//        Stream<String> stream=list.stream();
//        //收集过滤后的数据
//        System.out.println(stream.filter((e)->e.contains("java")).collect(Collectors.toList()));
//        //收集过滤后的数据
//        List<String> resultList=stream.filter((e)->e.contains("java")).collect(Collectors.toList());
//        System.out.println(resultList);

        //(3)skip与limit方法
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"1.java","2.C++","3.php");
        //实例化Stream对象
        Stream<String> stream=list.stream();
        List<String> resultList=stream.skip(0).limit(3)
                .map((s)->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}
