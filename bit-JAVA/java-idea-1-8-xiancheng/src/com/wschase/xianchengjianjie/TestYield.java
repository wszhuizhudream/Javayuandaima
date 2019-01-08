package com.wschase.xianchengjianjie;

/**线程让步
 * Author:WSChase
 * Created:2019/1/8
 */
public class TestYield {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();
        new Thread(runnable,"Thread-C").start();
    }
}
