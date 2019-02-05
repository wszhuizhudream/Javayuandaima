package com.bittech.pc;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestWait {
    
    public static void main(String[] args) {
        
        Object object = new Object();
        
        new Thread(() -> {
            synchronized(object) {
                object.notify();
            }
        }).start();
        
        synchronized(object) {
            System.out.println("同步开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步结束");
        }
    }
}
