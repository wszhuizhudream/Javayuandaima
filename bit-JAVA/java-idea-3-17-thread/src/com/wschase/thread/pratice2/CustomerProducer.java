package com.wschase.thread.pratice2;

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
                this.queue
            }
        }

    }
}
public class CustomerProducer {
}
