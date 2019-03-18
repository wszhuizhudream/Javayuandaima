package com.wschase.thread.n2;

/**二、java多线程实现
 * 1.继承Thread类实现多线程
 * Author:WSChase
 * Created:2019/3/17
 */
public class MyThread1 extends Thread{
    private String title;
    public MyThread1(String title){
        this.title=title;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(this.title+",i="+i);
        }
    }

    public static void main(String[] args) {
        //要想真正的引入多线程需要我们启动线程
        MyThread1 myThread1=new MyThread1("thread1");
        MyThread1 myThread2=new MyThread1("thread2");
        myThread1.start();
        myThread2.start();
    }
}
