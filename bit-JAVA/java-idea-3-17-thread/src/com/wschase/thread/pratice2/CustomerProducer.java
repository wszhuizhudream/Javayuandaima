package com.wschase.thread.pratice2;

import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者与消费者模型
 * Author:WSChase
 * Created:2019/3/18
 */
class Goodsp{
    private final String name;


    Goodsp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goodsp{" +
                "name='" + name + '\'' +
                '}';
    }
}

//生产者
class  Producer implements Runnable{
    //首先需要一个集合来存放商品
    private final Queue<Goodsp> queue;

    //需要一个监听器
      private final Object monitor;

    //需要一个自增长
    private final AtomicInteger atomicInteger;

    public Producer(Queue<Goodsp> queue, Object monitor, AtomicInteger atomicInteger) {
        this.queue = queue;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        synchronized (monitor){
            if(this.queue.size()==10){
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //利用String.valueOf将自增长的整型变为字符型作为商品名
                this.queue.add(new Goodsp(String.valueOf(atomicInteger.getAndAdd(1))));
            }
        }

    }
}

//消费者
class Customer implements Runnable{

    private final Queue<Goodsp> queue;

    private final Object monitor;

    public Customer(Queue<Goodsp> queue, Object monitor) {
        this.queue = queue;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            if(this.queue.isEmpty()){
                this.queue.notify();
            }else {
               Goodsp goodsp= this.queue.poll();
                System.out.println(goodsp);
            }
        }
    }
}
public class CustomerProducer {
    public static void main(String[] args) {
        Queue<Goodsp> queue=new LinkedList<>();
        Object monitor=new Object();
        AtomicInteger atomicInteger=new AtomicInteger();
        Producer producer=new Producer(queue,monitor,atomicInteger);
        Customer customer=new Customer(queue,monitor);
        new Thread(producer).start();
        new Thread(customer).start();
    }
}
