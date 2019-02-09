package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread6 {
    
    public static void main(String[] args) {
        Runnable runnable = new PrintRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "Thread-" + i).start();
        }
    }
}

class PrintRunnable implements Runnable {
    
    private int i = 0;
    
    @Override
    public synchronized void run() {
        System.out.println("@#" + Thread.currentThread().getName() + "-" + i++);
    }
}