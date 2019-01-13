package com.wschase.shengchanzhexiaofeizhe;

/**
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestWait {
    public static void main(String[] args) {

        Object object=new Object();
        new Thread(()->{
            synchronized (object){
                object.notify();//notify()表示唤醒一个线程（即通知）
            }
        }).start();
        synchronized (object){
            System.out.println("同步开始");
            try {
                object.wait();//如果没有人通知它，它将会停下来
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步结束");
        }
    }
}
