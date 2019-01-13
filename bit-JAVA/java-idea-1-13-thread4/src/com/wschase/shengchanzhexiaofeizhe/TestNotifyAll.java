package com.wschase.shengchanzhexiaofeizhe;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestNotifyAll {
    public static void main(String[] args) {
        Object object=new Object();
        new Thread(new MyRunnable(true,object),"生产者A").start();
        new Thread(new MyRunnable(true,object),"生产者B").start();
        new Thread(new MyRunnable(true,object),"生产者C").start();
        new Thread(new MyRunnable(false,object),"消费者A").start();
        new Thread(new MyRunnable(false,object),"消费者B").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MyRunnable implements Runnable{

    //如果是true表示生产者
    //如果是false表示消费者
    private final boolean flag;

    private final Object object;

    /**
     *
     * @param flag  表示生产者还是消费者
     * @param object 表示资源（锁）
     */

    MyRunnable(boolean flag,Object object) {
        this.flag = flag;
        this.object=object;
    }

    @Override
    public void run() {
        if(flag){
            this.waitMethod();
        }else{
            this.notifyMethod();
        }
    }

    //消费者通知
    private void notifyMethod() {
        synchronized (object){
            String name=Thread.currentThread().getName();
            System.out.println(name+"消费者开始");
            this.object.notifyAll();//给所有等待的线程通知
            System.out.println(name+"消费者结束");
        }
    }

    //生产者等待
    private void waitMethod() {
        synchronized (object) {
            while (true) {
                String name=Thread.currentThread().getName();
                System.out.println(name+"生产者开始");
                try {
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+"生产者结束");
            }
        }
    }
}
