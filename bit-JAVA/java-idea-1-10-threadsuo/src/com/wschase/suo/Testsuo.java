package com.wschase.suo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**线程的同步与死锁
 * Author:WSChase
 * Created:2019/1/10
 */
public class Testsuo {
    ///对于同步与死锁我们只需要掌握概念就可以了 
    public static void main(String[] args) {
        LockRunnable runnable=new LockRunnable();

        Thread thread1=new Thread(runnable,"黄牛A");
        Thread thread2=new Thread(runnable,"黄牛B");
        Thread thread3=new Thread(runnable,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class LockRunnable implements Runnable {

    private int tick = 10;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //我们把加锁放在try之前，把解锁放在fainally里面，这样可以保证我们的锁一定可以加锁和解锁成功
        //这样才可以达到我们想要的效果：就是一个线程不会长期的占用一把锁
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("-----");//不要让循环和锁紧挨着
            lock.lock();//加锁
            try {

                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "剩余票数" + --this.tick);

                }
            } finally {
                //多线程没有办法同时访问这块代码
                lock.unlock();//解锁

            }


        }

    }
}