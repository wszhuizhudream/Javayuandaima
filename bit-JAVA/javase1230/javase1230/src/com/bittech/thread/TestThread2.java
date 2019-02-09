package com.bittech.thread;

/**
 * 通过标记位的方式终止线程
 * <p>
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread2 {
    
    public static void main(String[] args) {
        MyRunnable2 myRunnable = new MyRunnable2();
        Thread thread = new Thread(myRunnable, "子线程");
        thread.start();
        try {
            //主线程休眠
            Thread.sleep(3000);
            
            //主动调用thread中断方法
            thread.interrupt();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable2 implements Runnable {
    
    
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "  循环执行第 " + ++i + " 次");
            try {
                
                //判断线程的中断情况
                boolean interruptedStatus = Thread.currentThread().isInterrupted();
                //非阻塞情况
                if (interruptedStatus) {
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断：" + Thread.currentThread().isInterrupted());
                return;
            }
        }
    }
    
    
}




