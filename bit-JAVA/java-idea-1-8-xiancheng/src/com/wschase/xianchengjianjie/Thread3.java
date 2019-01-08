package com.wschase.xianchengjianjie;

/**
 * Author:WSChase
 * Created:2019/1/8
 */
public class Thread3 extends Thread {
    private static int tick=10;//将它变为类的属性就可以实现共享了

    @Override
    public void run() {
        while(tick>0){
            System.out.println(this.getName()+"剩余:"+tick--+"张票");
        }
    }

    public static void main(String[] args) {
        //（1）这个是使用Thread来实现的
//        Thread3 thread1=new Thread3();
//        thread1.setName("Thread-A");
//        Thread3 thread2=new Thread3();
//        thread2.setName("Thread-B");
//        thread1.start();
//        thread2.start();
        //（2)使用Runnable来实现
        Runnable runnable=new Runnable() {
            private int tick=10;
            @Override
            public void run() {
                while(tick>0){
                    //ThreadcurrentThread()：表示获得当前线程的名字
                    System.out.println(Thread.currentThread()+"剩余:"+tick--+"张票");
                }
            }
        };
        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();
    }
}
