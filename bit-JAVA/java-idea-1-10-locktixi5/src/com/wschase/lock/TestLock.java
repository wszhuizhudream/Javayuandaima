package com.wschase.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:WSChase
 * Created:2019/1/10
 */

class MyThread implements Runnable{
    private int tick=500;
    private Lock lock=new ReentrantLock();


    @Override
    public void run() {
        for(int i=0;i<500;i++){
            try{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                if(tick>0){
                    System.out.println(Thread.currentThread().getName()+"还剩余"+tick--+"票");
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
public class TestLock {
    public static void main(String[] args) {
       MyThread mythread = new MyThread();
       Thread thread1=new Thread(mythread,"A");
       Thread thread2=new Thread(mythread,"B");
       Thread thread3=new Thread(mythread,"C");
       thread1.start();
       thread2.start();
       thread3.start();
    }
}
