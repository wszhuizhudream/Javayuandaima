package com.bittech.pool;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestExecutors {
    
    
    /**
     * 适用于：服务器负载不较高对资源有限制，可以采用固定线程数
     */
    public static void code1() {
        //固定数量的线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }
    
    /**
     * 适用于：任务按照顺序执行
     */
    public static void code2() {
        //单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }
    
    /**
     * 适用于：任务多但执行时间短或者服务器负载比较小
     */
    public static void code3() {
        //缓存线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 10_0000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + count.getAndAdd(1));
                }
            });
        }
        executorService.shutdown();
    }
    
    /**
     * 适用于：1.延迟执行任务（一次） 2.周期性执行任务（多次）
     */
    public static void code4() {
        //任务调度
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5, new ThreadFactory() {
            
            private final AtomicInteger threadId = new AtomicInteger(1);
            
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("调度任务线程：" + threadId.getAndAdd(1));
                return thread;
            }
        });
        
        service.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("这是一个一次性任务：" + Thread.currentThread().getName());
                    }
                }, 1, TimeUnit.SECONDS);
        
        
        service.scheduleAtFixedRate(new Runnable() {
                                        @Override
                                        public void run() {
                                            System.out.println("这个一个周期性任务A：" + LocalDateTime.now().toString() + " " + Thread.currentThread().getName());
                                        }
                                    },
                1, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Runnable() {
                                        @Override
                                        public void run() {
                                            System.out.println("这个一个周期性任务B：" + LocalDateTime.now().toString() + " " + Thread.currentThread().getName());
                                        }
                                    },
                1, 5, TimeUnit.SECONDS);
    }
    
    public static void main(String[] args) {
    
    
    }
    
}
