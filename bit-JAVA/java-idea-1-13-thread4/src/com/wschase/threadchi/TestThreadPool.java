package com.wschase.threadchi;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**手动创建一个线程池
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //1）创建线程池，只能指定那些参数的大小
        ThreadPoolExecutor executor1=new
                ThreadPoolExecutor(5,10,
                1,
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(15),
                new ThreadPoolExecutor.DiscardPolicy()//丢弃掉
                );


        //2）创建线程池--可以自己定义名字
        ThreadPoolExecutor executor2=new
                ThreadPoolExecutor(5, 10,
                1,
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(15),
                new ThreadFactory() {
                    private final AtomicInteger threadId=new AtomicInteger(1);
                    //把创建线程的逻辑交给用户：
                    //（1）用户可以决定这个线程在这是守护线程还是用户线程
                    //（2）用户可以在这把线程创建好以后给线程起名字

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread=new Thread(r);
                        thread.setName("自定义线程"+String.valueOf(threadId.getAndAdd(1)));
                    return thread;
                    }
                }
        );
        for(int i=0;i<10;i++){


            //1.创建
//        executor2.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });


            //2.提交
            //1）提交的是Runnable
            executor2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
         });

            //2）提交的是Callable
            Future<Integer> future=executor2.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    return new Random().nextInt(100);
                }
            });

            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
            //(3)关闭线程池
            //具体用哪一个由我们的任务来决定
        //1)shutdown安全关闭-->平滑关闭线程池
        executor2.shutdown();
        System.out.println(executor2.isShutdown());
        System.out.println(executor2.isTerminated());
        //2）shutdownNow()：非平滑关闭，有可能正在执行的任务不能完成

        //获得当前设备CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
