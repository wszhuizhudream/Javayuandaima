package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestNoThreadLocal {
    
    public static void main(String[] args) {
        
        Runnable runnable = new MyRunnable2();
        
        Thread t1 = new Thread(runnable, "线程1");
        Thread t2 = new Thread(runnable, "线程2");
        Thread t3 = new Thread(runnable, "线程3");
        t1.start();
        t2.start();
        t3.start();
    
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
}

class MyRunnable2 implements Runnable {
    
    private String value;
    
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        value = name;
        System.out.println(name + " 获取NoThreadLocal的值 " + value);
    
        
    }
}


