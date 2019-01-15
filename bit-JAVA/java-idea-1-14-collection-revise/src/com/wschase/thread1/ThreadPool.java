package com.wschase.thread1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**第7节：线程池
 * Author:WSChase
 * Created:2019/1/14
 * 创建三种线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.固定数量的线程池
        ExecutorService  executorService=Executors.newFixedThreadPool(5);
        final AtomicInteger count=new AtomicInteger(0);
        for(int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"=0");
                }
            });
        }
        executorService.shutdown();
    }
}
