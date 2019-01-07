package com.wschase.hashmap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:WSChase
 * Created:2019/1/7
 */
//二、队列-->先进先出
//解决高并发：我们把程序变成分布式-->将数据库同样分布10个，会分布分表（还可以备份）
public class TestQueue {
    //1.队列的常见操作
    public static void code1(){
        LinkedList<String> queue=new LinkedList<>();
        System.out.println("对列的元素是否为空"+queue.isEmpty());
        //入队列
        queue.add("java");
        queue.add("C++");
        queue.add("PHP");

        System.out.println("队列的元素是否为空"+queue.isEmpty());
        System.out.println("队列的数量："+queue.size());

        //查看队头
        System.out.println("队头元素为："+"PHP".equals(queue.peek()));

        //出队列
        System.out.println(queue.poll());//java
        System.out.println(queue.poll());//C++
        System.out.println(queue.poll());//PHP
        System.out.println(queue.poll());//?-->注意：当我们的队列为空的时候和栈不同，他不是指针异常，而是返回一个值null

    }

        //2.队列的应用
        //生产者-消费者模型
        //生产者和消费者的能力不匹配（生产的速度和消费的速度不匹配）
        //采用队列的方式存在生产消费的资源(元素)，解耦生产者和消费者的实现逻辑
    public static  void code2(){
        Queue<String>     queue=new LinkedList<>();
        //生产者
        new Thread(new Runnable() {
            {
                System.out.println("生产者线程启动");
            }
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(1000);
                        //生产数据
                        String data = String.valueOf(Math.random());
                        System.out.println("生产者："+data);
                        queue.add(data);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //消费者
        new Thread(new Runnable() {
            {
                System.out.println("消费者线程启动");
            }
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(1000);
                        System.out.println("消费者："+queue.poll());
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void main(String[] args) {

    }
}
