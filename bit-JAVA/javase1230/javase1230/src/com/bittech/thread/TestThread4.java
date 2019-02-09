package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread4 {
    
    
    public static void main(String[] args) {
        //主线程是非守护线程（用户线程）
//        System.out.println(Thread.currentThread().isDaemon());
        
        
        //线程ThreadA
        Thread threadA = new Thread(new DaemonRunnable(), "Thread-A");
        //必须在start之前调用
        threadA.setDaemon(true);//垃圾回收线程
        threadA.start();
        
        //线程ThreadB
        Thread threadB = new Thread(new DaemonRunnable(), "Thread-B");
        threadB.start();
        
        //主线程
        try {
            Thread.sleep(3000);
            threadB.interrupt();
            
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
    
}

class DaemonRunnable implements Runnable {
    
    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 调用第 " + ++i + " 次");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 中断");
        }
    }
}