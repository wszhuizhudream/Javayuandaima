package com.wschase.shengchanzhexiaofeizhe;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者消费者模型练习
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestSingelProducerCustomer {
    public static void main(String[] args) {
        //首先分别准备3个参数
        Queue<Goods1> goods1=new LinkedList<>();
        Object monitor=new Object();
        AtomicInteger atomicInteger=new AtomicInteger();
        Producer1 producer=new Producer1(goods1,monitor,atomicInteger);
        Producer1 producer1=new Producer1(goods1,monitor,atomicInteger);
        Customer1 customer=new Customer1(goods1,monitor);
        new Thread(producer,"生产者1").start();
        new Thread(producer1,"生产者2").start();
        new Thread(customer,"消费者").start();
    }

}

//首先是一个商品池
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
    //总共有三个要素：集合--》存放、监视器--》检测线程状态、自增长--》商品名称的序号
    private final Queue<Goods1> goods1;

    private final Object monitor;

    private final AtomicInteger atomicInteger;

    Producer1(Queue<Goods1> goods1, Object monitor, AtomicInteger atomicInteger) {
        this.goods1 = goods1;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitor){
            //首先要进行判断这个商品池是否已满，是否还需要生产者继续生产
            if(this.goods1.size()==10){
                try {
                    this.monitor.wait();//如果已经满了那么需要等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                Goods1 goods1=new Goods1(String.valueOf(atomicInteger.getAndAdd(1)));
                this.goods1.add(goods1);
                System.out.println(Thread.currentThread().getName()+"生产"+goods1);
            }
        }
        }

    }
}

//消费者
class Customer1 implements Runnable{

    private final Queue<Goods1> goods1;

    private final Object monitor;

    Customer1(Queue<Goods1> goods1, Object monitor) {
        this.goods1 = goods1;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitor){
            //消费者最重要的就是商品池为空的时候需要等待
            if(this.goods1.isEmpty()){
               this.monitor.notifyAll();

            }else{

            //商品池不为空的时候不需要等待,直接取出
                Goods1 goods1=this.goods1.poll();//取出商品
                System.out.println(Thread.currentThread().getName()+"消费"+goods1);
            }


        }
        }

    }
}









