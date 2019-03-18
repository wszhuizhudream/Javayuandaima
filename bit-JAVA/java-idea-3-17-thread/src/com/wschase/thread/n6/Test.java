package com.wschase.thread.n6;

/**生产者与消费者模型
 * Author:WSChase
 * Created:2019/3/18
 */
class Goods{
    //商品名称
    private String goodsName;
    //商品库存
    private int count;

    @Override
    public String toString() {
        return "Goods [goodsName="+goodsName+",库存为"+count+"]";
    }

    //生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        if (this.count > 0) {
            System.out.println("还有库存，等待消费者...");
            wait();
        }
        this.goodsName = goodsName;
        this.count = count + 1;
        Thread.sleep(1000);
        System.out.println("生产" + toString());
        //生产完商品后通知消费之可以消费了
        notify();
    }

        //消费方法
        public synchronized void get() throws InterruptedException {
            if(this.count==0){
                System.out.println("商品卖完了，稍等...");
                wait();
            }

            //每次消费一个商品
            this.count=count-1;
            Thread.sleep(1000);
            System.out.println("消费"+toString());
            //消费完告知生产者线程可以继续生产了
            notify();
        }

}

//生产者
class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        super();
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.set("面包一个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者
class Consumer implements Runnable{


    private Goods goods;

    public Consumer(Goods goods) {
        super();
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Goods goods=new Goods();
        Thread producer=new Thread(new Producer(goods),"生产者线程");
        Thread consumer=new Thread(new Consumer(goods),"消费者线程");
        consumer.start();
        producer.start();
    }

}
