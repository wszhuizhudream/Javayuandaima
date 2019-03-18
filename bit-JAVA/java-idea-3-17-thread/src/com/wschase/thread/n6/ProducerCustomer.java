package com.wschase.thread.n6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产消费者模型
 * Author:WSChase
 * Created:2019/3/18
 */
class Goods1{
    private final String name;

    Goods1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods1{" +
                "name='" + name + '\'' +
                '}';
    }
}


//生产者
class Producer1 implements Runnable{

    //需要把商品放到生产者里面，所以需要一个集合
    //注意：我们的商品集合需要是实现攻下给，所以在这个地方我们不能用new
    private final Queue<Goods1> goods1;

    private final Object monitor;//监听器

    private final AtomicInteger atomicInteger;//自增长
    Producer1(Queue<Goods1> goods1,Object monitor,AtomicInteger atomicInteger){
        this.goods1=goods1;
        this.monitor=monitor;
        this.atomicInteger=atomicInteger;
    }


    @Override
    public void run() {

        synchronized (monitor){
            //商品池满了，所以需要等待
            if(this.goods1.size()==10){
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //这个表示商品池没有满的时候，需要生产者生产商品
                //每次加1表示每次生产一个
                this.goods1.add(new Goods1(String.valueOf(atomicInteger.getAndAdd(1))));
            }
        }
    }
}

//消费者
class Customer1 implements Runnable{
    private final Queue<Goods1> goods2;

    private final Object monitor;

    public Customer1(Queue<Goods1> goods2, Object monitor) {
        this.goods2 = goods2;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            //生产者和消费者是共享同一个集合的，所以当消费者从集合中去取商品的死后发现集合里面的商品为空了
            //那么这个时候就需要生产者生产商品了。
            if(this.goods2.isEmpty()){
                //如果是空的就通知
                goods2.notifyAll();//唤醒生产者的线程
            }else {
                //如果不是空的就取一个
                Goods1 goods=this.goods2.poll();

                System.out.println(goods);
            }
        }
    }
}

public class ProducerCustomer {

    public static void main(String[] args) {
        //下面的这些变量对于生产者和消费者都是共享的
        Queue<Goods1> queue=new LinkedList<>();
        AtomicInteger goodsName=new AtomicInteger(1);
        Object monitor = new Object();
        Producer1 producer1 = new Producer1(queue,monitor,goodsName);
        Customer1 customer1=new Customer1(queue,monitor);
        new Thread(producer1).start();
        new Thread(customer1).start();

    }
}
