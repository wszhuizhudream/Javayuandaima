package com.wschase.producercustomer;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者与消费者模型:一个生产者对应一个消费者
 * Author:WSChase
 * Created:2019/3/24
 */
//首先来一个产品
    class Goods{
        private String name;

    public Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //因为最后要输出这个商品的信息，所以需要我们覆写toString方法
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}

//生产者:上一个线程形成一个生产链
class Producer implements Runnable{

        //不希望这个属性被修改
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
            if(goods.size()==10){//最多只允许生产10个

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

//消费者：也是一个线程
class Customer implements Runnable{

        //生产者需要这个集合是因为需要从这个集合里面拿产品来消费
        private final Queue<Goods> goods;

        private final Object monitor;

    public Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {

        synchronized (monitor){
            if(goods.isEmpty()){
                this.goods.notify();
            }else {
                //这是一个队列
                Goods goodsxiaofei=this.goods.poll();
                System.out.println(goodsxiaofei);
            }
        }

    }
}
public class ProducerCustomer {
    public static void main(String[] args) {
        Queue<Goods> goods=new LinkedList<>();//因为LinkedList是一个双向量表，更易于我们管理，所以我们选择了这个集合

        Object monitor=new Object();

        AtomicInteger atomicInteger=new AtomicInteger();

        Producer producer=new Producer(goods,monitor,atomicInteger);
        Customer customer=new Customer(goods,monitor);

        //分别启动一个生产者和消费线程
        new Thread(producer).start();
        new Thread(customer).start();
    }

}
