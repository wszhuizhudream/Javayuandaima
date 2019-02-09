package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread5 {
    
    public static void main(String[] args) {
        
        //共享业务逻辑
        Runnable runnable = new TicketRunnable();
        
        Thread threadA = new Thread(runnable, "黄牛A");
        Thread threadB = new Thread(runnable, "黄牛B");
        Thread threadC = new Thread(runnable, "黄牛C");
        
        threadA.start();
        threadB.start();
        threadC.start();
        
    }
    
}

class TicketRunnable implements Runnable {
    
    //默认票有10张
    private int ticket = 10;

//    @Override
//    public void run() {
//        synchronized(this) { //Runnable对象
//            while (this.ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + " 还剩余 " + (this.ticket--) + " 张票");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            System.out.println(Thread.currentThread().getName() + " 票卖光了");
//        }
//    }

//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("-----------");
//            synchronized(this) { //Runnable对象
//                if (this.ticket > 0) {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println(Thread.currentThread().getName() + " 还剩余 " + (this.ticket--) + " 张票");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + " 票卖光了");
//    }


//    @Override
//    public synchronized void run() {
//        for (int i = 0; i < 10; i++) {
//            if (this.ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + " 还剩余 " + (this.ticket--) + " 张票");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + " 票卖光了");
//    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("----");
            sale();
        }
        System.out.println(Thread.currentThread().getName() + " 票卖光了");
    }
    
    private synchronized void sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 还剩余 " + (this.ticket--) + " 张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
