package com.bittech.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestStream {
    
    public static void code1() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "Python", "PHP");
        long count = list.stream().map(String::toLowerCase).limit(2).count();
        System.out.println(count);
    }
    
    public static void code2() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C", "JavaScript", "Python", "PHP");
        list.stream().map(String::toLowerCase).forEachOrdered(System.out::println);
    }
    
    public static void code3() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1、Java", "2、C++", "3、Python", "4、JavaScript", "5、Nginx", "6、Tomcat");
        System.out.println(
                list.stream()
                        .skip(2).limit(3)
                        .map(String::toLowerCase)
                        .filter(s -> s.contains("t"))
                        .collect(Collectors.toList()));//["6、Tomcat"]
        
    }
    
    
    public static void mapReduceA() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        
        orderList.stream()
                .mapToDouble(order -> order.getAmount() * order.getPrice())//map
                .reduce((left, right) -> left + right) //reduce
                .orElseGet(() -> 0);
        
    }
    
    public static void mapReduceB() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        
        DoubleSummaryStatistics summaryStatistics = orderList.stream()
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .summaryStatistics();
        
        System.out.println("总和：" + summaryStatistics.getSum());
        System.out.println("数量：" + summaryStatistics.getCount());
        System.out.println("平均值：" + summaryStatistics.getAverage());
        System.out.println("最大值：" + summaryStatistics.getMax());
        System.out.println("最小值：" + summaryStatistics.getMin());
    }
    
    public static void main(String[] args) {
        
        HashMap<String, String> hashMap = new HashMap<>();
        
        for (int i = 0; i < 32; i++) {
            hashMap.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println(hashMap);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


class Order {
    private String title;
    private double price;
    private int amount;
    
    public Order(String title, double price, int amount) {
        this.title = title;
        this.price = price;
        this.amount = amount;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}