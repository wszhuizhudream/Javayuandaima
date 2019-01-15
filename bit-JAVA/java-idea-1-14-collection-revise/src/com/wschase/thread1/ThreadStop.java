package com.wschase.thread1;

/**线程常用方法——线程终止
 * 线程终止一共有三种方法：
 * （1）设置标记位，线程正常退出
 * （2）使用stop方法强制退出，但是不安全，现在已经不适用这种方法了
 * （3）使用Thread类中的一个interrupt()中断线程
 * Author:WSChase
 * Created:2019/1/14
 */

class MyRunnable2 implements Runnable{

    private boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //设置标记位
    @Override
    public void run() {
        int i=0;
        while (this.flag){
            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i+"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class ThreadStop {
    public static void code1(){
        //方法1：标记位的方法让线程终止
        MyRunnable2 myRunnable=new MyRunnable2();
        Thread thread=new Thread(myRunnable,"子线程");
        thread.start();

        //主线程休眠
        try {
            Thread.sleep(1000);
            //线程终止：通过修改标记位
            myRunnable.setFlag(false);//当我们的标记位为false时，自然就不会执行线程中的run()方法了
            //此时线程就被终止了。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        //方法3：通过中断让线程终止
        MyRunnable2 myRunnable2=new MyRunnable2();
        Thread thread2=new Thread(new MyRunnable2(),"子线程");
        thread2.start();

        //主线程休眠
        try {
            Thread.sleep(1000);

            //中断子线程
            thread2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
