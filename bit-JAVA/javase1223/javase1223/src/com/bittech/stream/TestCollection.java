package com.bittech.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/12/23
 */
public class TestCollection {
    
    public static void code1() {
        //forEach -> Iterable
        //stream  -> Collection
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScript");

//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        list.forEach(s-> System.out.println(s));

//        list.forEach(System.out::println);


//        System.out.println(list.stream().count());
//        list.stream()
//                .filter(s -> s.contains("Java"))
//                .map(s-> s.toUpperCase())
//                .forEach(System.out::println);

//        List<String> newList = new ArrayList<>();
//        for (String item : list) {
//            if (item.contains("Java")) {
//                newList.add(item.toUpperCase());
//            }
//        }
//        System.out.println(newList);

//        List<String> newList = list
//                .stream()
//                .filter(s -> s.contains("Java"))
//                .map(s -> s.toUpperCase())
//                .collect(Collectors.toList());
//        System.out.println(newList);

//        List<Integer> intList = new ArrayList<>();
//        intList.add(1);
//        intList.add(2);
//        intList.add(3);
//
//        List<String> stringList = intList.stream().map(integer -> String.valueOf(integer))
//                .collect(Collectors.toList());
//        System.out.println(stringList);
        
        
        //符合添加的元素个数统计
        Long count = list.stream()
                .filter(s -> s.contains("Java"))
                .count();
        System.out.println("包含Java的元素有：" + count);
    }
    
    public static void code2() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1、Java", "2、C++", "3、Python", "4、JavaScript", "5、Nginx", "6、Tomcat");


//        list.stream()
//                .skip(7)
//                .limit(1)
//                .forEach(System.out::println);
        
        list.stream()
                .skip(1)
                .limit(3)
                .filter(s -> s.contains("Java"))
                .forEach(System.out::println);
    }
    
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("Java");
//        list.add("C++");
//        list.add("Python");

//        Collections.addAll(list, "Java", "C++", "Python");

//        System.out.println(Collections.binarySearch(list, "Java"));
        
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);
        System.out.println(Collections.binarySearch(list, 2));
    }
}
