package com.bittech.pool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestThreadPool {
    
    public static void main(String[] args) {
        
        //通过自定义的方式创建线程池执行器

//        ThreadPoolExecutor executor1 = new
//                ThreadPoolExecutor(
//                5, 10,
//                1,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(15),
//                new ThreadPoolExecutor.DiscardPolicy()
//        );
//
        ThreadPoolExecutor executor2 = new
                ThreadPoolExecutor(
                5, 10,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(15),
                new ThreadFactory() {
                    private final AtomicInteger threadId = new AtomicInteger(1);
                    
                    //把创建线程的逻辑交给用户
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("自定义线程" + String.valueOf(threadId.getAndAdd(1)));
                        return t;
                    }
                }
        );


//        for (int i = 0; i < 10; i++) {
//            //execute : Executor
//            executor1.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//        }
        
        //线程池执行器的任务提交方式
        for (int i = 0; i < 10; i++) {
            //execute : Executor
//            executor2.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
            
            
            Future<Integer> future = executor2.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return new Random().nextInt(100);
                }
            });
            
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        //1.shutdown : 平滑关闭线程池
        //2.shutdown : 非平滑关闭线程池，有可能正在执行的任务没有完成
//        executor2.shutdown();
        executor2.shutdownNow();
        System.out.println(executor2.isShutdown());
        System.out.println(executor2.isTerminated());
        
        
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
