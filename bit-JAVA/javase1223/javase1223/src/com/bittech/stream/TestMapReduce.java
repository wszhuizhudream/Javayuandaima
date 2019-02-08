package com.bittech.stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: secondriver
 * Created: 2018/12/23
 */
public class TestMapReduce {
    
    public static void code1() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        
        //计算金额总和
//        double total = 0.0D;
//        for (Order order : orderList) {
//            total += order.getPrice() * order.getAmount();
//        }
//        System.out.println("总金额是：" + total);
        
        //fork-join
        //map - reduce 进行的总额计算
        double totalPrice = orderList
                .stream()
                .mapToDouble(o -> o.getPrice() * o.getAmount())
                //DoubleStream 里面的每个元素求和
                //[10.4,22.4,18.5]
                //left right
                //sum = 0
                //sum(left) 10.4(right) -> sum= left + right = 0 + 10.4
                //sum(left) 22.4(right) -> sum = left + right = 10.4 + 22.4
                .reduce((sum, x) -> sum + x)
                .orElse(0);
        
        System.out.println("订单总价：" + totalPrice);
        
        
        //map-reduce 统计分析
        DoubleSummaryStatistics summaryStatistics = orderList.stream()
                .mapToDouble(o -> o.getPrice() * o.getAmount())
                .summaryStatistics();
        //有多少订单，最大订单，最小订单，总额，平均值
        System.out.println("数量：" + summaryStatistics.getCount());
        System.out.println("最大值：" + summaryStatistics.getMax());
        System.out.println("最小值：" + summaryStatistics.getMin());
        System.out.println("总和：" + summaryStatistics.getSum());
        System.out.println("平均值：" + summaryStatistics.getAverage());
    }
    
    public static void main(String[] args) {
        
        
        //分组
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        
        orderList.add(new Order("中性笔", 2, 20));
        orderList.add(new Order("外星人笔记本", 1000, 1));

//        //订单分组
//        Map<String, List<Order>> map = new HashMap<>();
//        for (Order order : orderList) {
//            if (map.containsKey(order.getTitle())) {
//                map.get(order.getTitle()).add(order);
//            } else {
//                List<Order> orders = new ArrayList<>();
//                orders.add(order);
//                map.put(order.getTitle(), orders);
//            }
//        }
//        //计算title相同的订单金额
//        Map<String, Double> doubleMap = new HashMap<>();
//        for (Map.Entry<String, List<Order>> entry : map.entrySet()) {
//            String title = entry.getKey();
//            List<Order> orders = entry.getValue();
//            double sum = 0.0D;
//            for (Order o : orders) {
//                sum += o.getPrice() * o.getAmount();
//            }
//            doubleMap.put(title, sum);
//        }
//        System.out.println(doubleMap);
        
        //Stream , group by , foreach
        Map<String, Double> doubleMap = new HashMap<>();
        orderList.stream()
                .collect(Collectors.groupingBy(Order::getTitle))
                .forEach((k, v) -> {
                    //String k
                    //List<Order> v
                    double total = v.stream()
                            .mapToDouble(o -> o.getPrice() * o.getAmount())
                            .reduce((sum, x) -> sum + x)
                            .orElse(0);
                    
                    
                    doubleMap.put(k, total);
                    
                });
        System.out.println(doubleMap);
        
    }
}
