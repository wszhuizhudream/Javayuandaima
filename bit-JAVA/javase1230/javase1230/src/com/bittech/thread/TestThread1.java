package com.bittech.thread;

/**
 * 通过标记位的方式终止线程
 * <p>
 * Author: secondriver
 * Created: 2018/12/30
 */
public class TestThread1 {
    
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "子线程");
        thread.start();
        try {
            //主线程休眠
            Thread.sleep(3000);
            //修改标记位
            //myRunnable.setFlag(false);
            
            //直接调用stop
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable {
    
    private boolean flag = true;
    
    @Override
    public void run() {
        int i = 0;
        while (this.flag) {
            System.out.println(Thread.currentThread().getName() + "  循环执行第 " + ++i + " 次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}




