package com.wschase.thread1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**第6节：生产者与消费者模型2——多个生产者，多个消费者
 * Author:WSChase
 * Created:2019/1/14
 */

//商品池
class Goods1{
    private final String name1;//商品名称

    Goods1(String name1) {
        this.name1 = name1;
    }

    @Override
    public String toString() {
        return "Goods1{" +
                "name1='" + name1 + '\'' +
                '}';
    }
}

//生产者
class Producer1 implements Runnable{

    private final Queue<Goods1> goods1;

    private final Object monitor1;

    private final AtomicInteger atomicInteger1;

    Producer1(Queue<Goods1> goods1, Object monitor1, AtomicInteger atomicInteger1) {
        this.goods1 = goods1;
        this.monitor1 = monitor1;
        this.atomicInteger1 = atomicInteger1;
    }

    @Override
    public void run() {
        synchronized (monitor1){

        if(this.goods1.size()==10){
            try {
                this.goods1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Goods1 goods1= new Goods1(String.valueOf(atomicInteger1.getAndAdd(1)));
            this.goods1.add(goods1);
            System.out.println("生产商品："+goods1);
        }

    }
        }
}

//消费者
class Customer1 implements Runnable{

    private final Queue<Goods1> goods1;

    private final Object monitor1;

    Customer1(Queue<Goods1> goods1, Object monitor1) {
        this.goods1 = goods1;
        this.monitor1 = monitor1;
    }

    @Override
    public void run() {
        synchronized (monitor1){

        if(this.goods1.isEmpty()){
            this.goods1.notifyAll();
        }else {
            Goods1 goods1=this.goods1.poll();
            System.out.println("消费商品为："+goods1);
        }

    }
        }
}
public class ProducerCustomer2 {
    public static void main(String[] args) {
        Queue<Goods1> goods1=new LinkedList<>();
        Object monitor1=new Object();
        AtomicInteger atomicInteger1=new AtomicInteger();

        Producer1 producer1=new Producer1(goods1,monitor1,atomicInteger1);
        Producer1 producer2=new Producer1(goods1,monitor1,atomicInteger1);
        Customer1 customer1=new Customer1(goods1,monitor1);


        Thread thread11=new Thread(producer1);
        Thread thread33=new Thread(producer2);

        Thread thread22=new Thread(customer1);
        thread11.start();
        thread22.start();
        thread33.start();
    }
}
