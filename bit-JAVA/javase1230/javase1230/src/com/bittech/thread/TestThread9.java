package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread9 {
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new MyThread9();
            t.setName("Thread-" + i);
            t.start();
        }
        
        synchronized(TestThread9.class){
            
            synchronized(TestThread9.class){
            
            }
        
        }
    }
}

class Sync9 {
    
    public void test() {
        //synchronized(class) 全局锁
        //synchronized(this|obj) 对象锁
        synchronized(Sync9.class) {
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

class MyThread9 extends Thread {
    
    @Override
    public void run() {
        Sync9 sync = new Sync9();
        sync.test();
    }
}
