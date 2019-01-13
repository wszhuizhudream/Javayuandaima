package com.wschase.shengchanzhexiaofeizhe;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者消费者模型
 * Author:WSChase
 * Created:2019/1/13
 */
public class ProducerCustomer {

    public static void main(String[] args) {
        Queue<Goods> queue=new LinkedList<>();
        AtomicInteger goodsName=new AtomicInteger(1);//自增长是商品的name的编号
        Object monitor=new Object();//监听器--监听器都是Object类
        Producer producer1=new Producer(queue,monitor,goodsName);
        Producer producer2=new Producer(queue,monitor,goodsName);
        Customer customer1=new Customer(queue,monitor);
        new Thread(producer1,"生产者1").start();
        new Thread(producer2,"生产者2").start();
        new Thread(customer1).start();
    }

}

//商品
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
//需要把商品放到生产者里面，所以它需要有一个集合
    private final Queue<Goods> goods;//注意在这个地方我们一定不能new，因为我们需要实现共享，需要传入进来

    private final Object monitor;//监听器-->作为锁来处理

    private final AtomicInteger atomicInteger;//自增长
    Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
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
            //商品池满了，所以需要等待
            if(this.goods.size()==10){//如果等于10表示已经满了
                try {
                    this.monitor.wait();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //这个表示商品池没有满的时候，需要生产者生产商品，每次加1表示每次生产一个
                Goods goods=new Goods(String.valueOf(atomicInteger.getAndAdd(1)));
                this.goods.add(goods);
                System.out.println(Thread.currentThread().getName()+"生产"+goods);//打印出谁生产的
            }
        }
    }
        }
}


//消费者
class Customer implements Runnable{

    private final Queue<Goods> goods;//注意在这个地方我们一定不能new，因为我们需要实现共享，需要传入进来

    private final Object monitor;//监听器

    Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
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
            if(this.goods.isEmpty()){
                //如果是空的就通知
                this.monitor.notifyAll();
            }else {
                //如果不是空的就取一个，消费张品
                Goods goods=this.goods.poll();

                System.out.println("消费者消费"+goods);
            }
        }

    }
        }
}
