package com.wschase.thread.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**一个生产者对应一个消费者的生产者消费之模型
 * Author:WSChase
 * Created:2019/3/18
 */
//首先我们需要有一个商品的类
    class Goods1{
        private final String name;

    public Goods1(String name) {
        this.name = name;
    }

    //因为后面需要将这个商品打印出来，所以我们覆写toString方法

    @Override
    public String toString() {
        return "Goods1{" +
                "name='" + name + '\'' +
                '}';
    }
}

//生产者
class Producer implements Runnable{
        //首先需要一个集合来存放商品
        private final Queue<Goods1> goods11;

        //然后需要一个监听器来监听线程的状态
    private final Object monitor;

    //最后生产商品是资格一个生产的，所以中自增长，所以需要一个自增长
    private final AtomicInteger atomicInteger;

    public Producer(Queue<Goods1> goods1, Object monitor, AtomicInteger atomicInteger) {
        this.goods11 = goods1;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        synchronized (monitor){
            //加入我们规定最多课生产10个产品
            if(this.goods11.size()==10){
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }   else {
                this.goods11.add(new Goods1(String.valueOf(atomicInteger.getAndAdd(1))));
            }
        }
    }
}


//消费者
class Customer11 implements Runnable{
        private final Queue<Goods1> goods12;

        private final Object monitor;

    public Customer11(Queue<Goods1> goods12, Object monitor) {
        this.goods12 = goods12;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            if(this.goods12.isEmpty()){
                this.goods12.notify();
            }  else {
                Goods1 goods13=this.goods12.poll();
            System.out.println(goods13);
            }
        }
    }
}
public class ProducerCustomer1 {
    public static void main(String[] args) {
        Queue<Goods1> queue=new LinkedList<>();
        Object monitor=new Object();
        AtomicInteger atomicInteger=new AtomicInteger();
        Producer producer=new Producer(queue,monitor,atomicInteger);
        Customer11 customer=new Customer11(queue,monitor);
        new Thread(producer).start();
        new Thread(customer).start();
    }
}
