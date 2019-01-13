package com.wschase.threadchi;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**对Executors进行详解
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestExecutors {

    /**
     * 适用于：服务器负载比较高对资源有限制，可以采用固定线程数
     */
    public static void code1(){
        //1.固定数量的线程池——适用于
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        final AtomicInteger count=new AtomicInteger(0);
        for(int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    //提交任务
                    System.out.println(Thread.currentThread().getName()+"=0"+count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();

    }

    /**
     * 适用于：任务按照顺序执行
     */
    public static void code2(){
        //2.SingleThreadPoolExecutor单线程的线程池
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        final AtomicInteger count=new AtomicInteger(0);
        for(int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    //提交任务
                    System.out.println(Thread.currentThread().getName()+"="+count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();

    }

    /**
     * 适用于：任务多但执行时间短或者服务器负载比较小
     */
    public static void code3(){
        //3.缓存线程
        ExecutorService executorService= Executors.newCachedThreadPool();
        final AtomicInteger count=new AtomicInteger(0);
        for(int i=0;i<10000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    //提交任务
                    System.out.println(Thread.currentThread().getName()+"="+count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();

    }
    public static void main(String[] args) {

        //4.任务调度——适用于定时的处理一些任务
       ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5, new ThreadFactory() {
            private final AtomicInteger threadId=new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("调度任务线程"+threadId.getAndAdd(1));
                return thread;
            }
        });


           //1)一次性任务
           scheduledExecutorService.schedule(
                   new Runnable() {
               @Override
               public void run() {
                   System.out.println("这是一个一次任务");
               }
           },1,TimeUnit.SECONDS);

           //2)周期性任务
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个周期性任务"+LocalDateTime.now().toString()+""+Thread.currentThread().getName());
            }
        },1,2,TimeUnit.SECONDS);
        //当我们调用shutdown后将会直接全部终止，不能执行；所以我们的定时任务一般不会调用shutdown
        scheduledExecutorService.shutdown();

    }
}
