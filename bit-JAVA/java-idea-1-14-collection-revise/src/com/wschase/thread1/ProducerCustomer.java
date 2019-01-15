package com.wschase.thread1;

import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**第6小节：生产者与消费者模型——一个消费者一个生产者
 * Author:WSChase
 * Created:2019/1/14
 */
//首先需要一个商品
class Goods{
    private final String name;

    Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}


//生产者
class Producer implements Runnable{

    //对于生产者一共需要三个要素：队列（商品池）——>存放商品、监视器——>实现线程同步、自增长——>生产时候的参数传递

    private final Queue<Goods> goods;//这个队列是用来存放商品的

    private final Object monitor;

    private final AtomicInteger atomicInteger;

    Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        synchronized (monitor){

        //线程需要实现的功能
        if(this.goods.size()==10){//已经满了，需要等待
            try {
                this.monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            //没有满则需要进行生产
           Goods goods = new Goods(String.valueOf(atomicInteger.getAndAdd(1)));
           this.goods.add(goods);//上产一个商品：将商品加入到商品池中
            System.out.println("生产的商品为："+goods);//将生产的商品输出
        }
        }

    }
}


//消费者
class Customer implements Runnable{

//对于消费者需要两个元素：队列（商品池）——>取商品、监视器——>实现线程同步
    private final Queue<Goods> goods;

    private final Object monitor;

    Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }


    @Override
    public void run() {
        //线程需要实现的功能——也就是消费者的一些行为
        synchronized (monitor){
            if(this.goods.isEmpty()){
                //对于消费者，商品池为空的时候需要通知生产者生产
                this.monitor.notifyAll();
            }else {
                //商品池不为空取一个商品
                Goods goods=this.goods.poll();
                System.out.println("消费的商品"+goods);//输出取出的商品
            }
        }

    }
}
public class ProducerCustomer {
    public static void main(String[] args) {
        //首先准备需要创建线程的生产者、消费者两个类
        Queue<Goods> goods=new LinkedList<>();
        Object monitor=new Object();
        AtomicInteger atomicInteger=new AtomicInteger();

        //创建一个生产者
        Runnable runnable1=new Producer(goods,monitor,atomicInteger);

        //创建一个消费者
        Runnable runnable2=new Customer(goods,monitor);

        //分别创建生产者、消费者的线程
        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);
        thread1.start();
        thread2.start();

    }
}
