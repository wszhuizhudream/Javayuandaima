package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread7 {
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new MyThread();
            t.setName("Thread-" + i);
            t.start();
        }
    }
}

class Sync {
    
    public synchronized void test() {
        System.out.println("Sync对象的Test方法执行开始：" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync对象的Test方法执行结束：" + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}