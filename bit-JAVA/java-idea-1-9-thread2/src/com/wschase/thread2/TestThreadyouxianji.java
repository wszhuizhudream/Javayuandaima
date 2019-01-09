package com.wschase.thread2;

/**
 * Author:WSChase
 * Created:2019/1/9
 */
public class TestThreadyouxianji {
    public static void code1(){
        //主线程的优先级
        System.out.println("主线程的优先级："+Thread.currentThread().getPriority());

        //在主线程中创建一个线程不指定优先级
        Thread threadA=new Thread(()->{
            System.out.println(Thread.currentThread().getName()
                    +"优先级是："+Thread.currentThread().getPriority());
        },"Thread-A");
        threadA.start();
        //当我们没有改变优先级的时候，这个Thread-A的优先级就是府县丞的优先级：5
        threadA.setPriority(6);

    }
    public static void main(String[] args) {
        //主线程是非守护线程
        System.out.println(Thread.currentThread().isDaemon() );
    }
}
