package com.wschase.thread1;

/**第三节：线程常用操作方法
 * Author:WSChase
 * Created:2019/1/14
 */
class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=5;i++){
            System.out.println("当前运行线程"+Thread.currentThread().getName()+",i="+i);

//三、线程的休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//四、线程让步
            Thread.yield();


        }
    }
}
public class ThreadTools {
    public static void main(String[] args) {
//一、一些常用的方法
        MyRunnable1 r1=new MyRunnable1();
        Thread t1=new Thread(r1);//系统自动取名
        Thread t2=new Thread(r1,"线程A");
        //t3先创建再起名
        Thread t3=new Thread(r1);
        t3.setName("线程B");

        //启动线程
        t1.start();
        t2.start();
        t3.start();

//二、设置线程的优先级
 t1.setPriority(Thread.NORM_PRIORITY);
 t2.setPriority(Thread.MAX_PRIORITY);


 //五、线程加入:让main线程阻塞，让当前线程执行
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
