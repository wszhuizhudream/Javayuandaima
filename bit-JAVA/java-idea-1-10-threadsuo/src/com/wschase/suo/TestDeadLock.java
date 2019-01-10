package com.wschase.suo;

/**死锁
 * Author:WSChase
 * Created:2019/1/10
 */
public class TestDeadLock {

    //资源笔
    private static Pen pen=new Pen();

    //资源书
    private static Book book=new Book();
    public static void main(String[] args) {

        //线程1
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book){
                    System.out.println(Thread.currentThread().getName()+"我有书，但是还在用");

                    synchronized (pen){
                        System.out.println(Thread.currentThread().getName()+"想做笔记，但是没有笔，把你的给我");
                    }
                }
            }
        },"Thread-A");



        //线程2
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen){
                    System.out.println(Thread.currentThread().getName()+"我有笔，但是还在用");

                    synchronized (book){
                        System.out.println(Thread.currentThread().getName()+"想看书，但是没有书，把你的给我");
                    }
                }
            }
        },"Thread-B");

        thread1.start();
        thread2.start();

    }
}

class Pen{
    private String name="笔";

    public String getName() {
        return name;
    }
}

class Book{
    private String name="书";

    public String getName() {
        return name;
    }
}
