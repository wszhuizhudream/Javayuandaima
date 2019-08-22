package com.wschase.producerandcustomer;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者与消费者模型
 * Author:WSChase
 * Created:2019/3/21
 */
//首先准备一个需要生产的商品
    class Goods{
        private String name;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Producer implements Runnable{
        private final Queue<Goods> goods;

        private final Object monitor;

        private final AtomicInteger atomicInteger;

    public Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }


    @Override
    public void run() {
        synchronized (monitor){
            if(goods.size()==10){
                try {
                    this.goods.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                this.goods.add(new Goods(String.valueOf(atomicInteger)));
            }
        }
    }
}

class Customer implements Runnable{
        private final Queue<Goods> goods;

        private final Object monitor;

    public Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            if(this.goods.isEmpty()){
                this.goods.notify();
            }else {
                Goods goods=this.goods.poll();
                System.out.println(goods);//输出对象
            }
        }
    }
}
public class Client {
    public static void main(String[] args) {

        Queue<Goods> goods=new LinkedList<>();

        Object monitor=new Object();

        AtomicInteger atomicInteger=new AtomicInteger();
        Producer producer=new Producer(goods,monitor,atomicInteger);
        Customer customer=new Customer(goods,monitor);
        new Thread(producer).start();
        new Thread(customer).start();
    }
}
