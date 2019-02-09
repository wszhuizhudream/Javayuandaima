package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread8 {
    
    public static void main(String[] args) {
        Sync2 sync2 = new Sync2();
        for (int i = 0; i < 3; i++) {
            Thread t = new MyThread2(sync2);
            t.setName("Thread-" + i);
            t.start();
        }
    }
}

class Sync2 {
    
    //synchronized 同步的是 Sync2的对象的方法
//    public synchronized void test() {
//        System.out.println("Sync对象的Test方法执行开始：" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Sync对象的Test方法执行结束：" + Thread.currentThread().getName());
//    }
    //synchronized(this) 同步的是 Sync2的对象
    public void test() {
        synchronized(this) {
            System.out.println("Sync对象的Test方法执行开始：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync对象的Test方法执行结束：" + Thread.currentThread().getName());
        }
    }
}

class MyThread2 extends Thread {
    
    private final Sync2 sync;
    
    MyThread2(Sync2 sync) {
        this.sync = sync;
    }
    
    @Override
    public void run() {
        sync.test();
    }
}