package com.wschase.xianchengjianjie;

import sun.plugin2.message.Message;

/**
 * Author:WSChase
 * Created:2019/1/8
 */
public class TestJoin {
    //我们在一个线程里面如果调用了其他线程的join()方法，它就会阻塞当前线程，
    // 直到我们被调用的线程对象里面的run()方法执行完毕，这个线程才会继续执行。
    public static void main(String[] args) throws InterruptedException {
        //业务逻辑
        MyRunnable runnable=new MyRunnable();

        //线程
        Thread thread=new Thread(runnable,"Thread-A");
        thread.start();

        //在主线程中调用线程对象的join方法，会阻塞主线程
        //直到调用线程对象的run方法执行完毕，主线程才会继续执行
        thread.join();


        System.out.println("当前线程"+Thread.currentThread().getName());//main
    }

}
class MyRunnable implements Runnable{
    private int tick=100;
    @Override
    public void run() {
        while(this.tick>0){
            System.out.println(Thread.currentThread().getName()+"tick="+tick--);
        }
    }
}
