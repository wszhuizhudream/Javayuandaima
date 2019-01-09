package com.wschase.stream;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Author:WSChase
 * Created:2019/1/9
 */
class Order{
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

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    //随后在list集合中保存这些订单的信息
}

//实现订单信息保存后进行总量的统计
public class TestMapReduce {
    public static void main(String[] args) {
    List<Order> order=new ArrayList<>();
    order.add(new Order("Iphone",8999.99,10));
    order.add(new Order("外星人笔记本",1299.99,5));
    order.add(new Order("MacBookPro",18999.99,5));
    order.add(new Order("java从入门到精通",9.99,2000));
    order.add(new Order("中性笔",1.99,2000));
    double allPrice=order.stream().map((obj)->obj.getPrice()*obj.getAmount())
            .reduce((sum,x)->sum+x).get();
        System.out.println("所花费的总额"+allPrice);

        //为了更好的观察结果下面再进行统计分析
        DoubleSummaryStatistics dss=order.stream().mapToDouble((obj)->obj.getPrice()*obj.getAmount())
                .summaryStatistics();
        System.out.println("总量："+dss.getCount());
        System.out.println("平均值："+dss.getAverage());
        System.out.println("最大值："+dss.getMax());
        System.out.println("最小值："+dss.getMin());
        System.out.println("总和："+dss.getSum());
    }
}
