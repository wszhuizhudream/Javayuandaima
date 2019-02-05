package com.bittech.pc;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestLockSupport {
    
    public static void main(String[] args) {
        
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始执行");
                LockSupport.park();
                System.out.println("线程结束执行");
            }
        });
        
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
        
    }
}
