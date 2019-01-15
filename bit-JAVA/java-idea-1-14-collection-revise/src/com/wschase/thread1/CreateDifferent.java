package com.wschase.thread1;

/**第二节：对于继承Thread和实现Runnable两种方法实现线程的创建的对比
 * Author:WSChase
 * Created:2019/1/14
 * 一般情况下，我们优先选择的是实现Runnable接口来创建线程
 * 下面我们举一个卖票的例子来对比它们
 */

//通过继承Thread创建线程
class MyThread extends Thread{
    private int tick=10; //票数
    private String name; //线程创建时的名称



    public MyThread( String name) {
        setName(name);
    }

    @Override
    public void run() {
        while (tick>0){
            System.out.println(Thread.currentThread().getName()+"剩余票数:"+tick--);
        }
    }

}

//通过实现Runnable接口实现创建线程
class MyRunnable implements Runnable{

    private int tick=10;


    public MyRunnable() {

    }

    @Override
    public void run() {
        while (tick>0){
            System.out.println(Thread.currentThread().getName()+"剩余票数:"+tick--);
        }
    }

}
public class CreateDifferent {
    public static void main(String[] args) {

//        //方法1：继承Thread——不能实现数据共享
//        System.out.println("创建线程方法1：继承Thread如下");
//        Thread t1=new MyThread("线程A");
//        Thread t2=new MyThread("线程B");
//        t1.start();
//        t2.start();

        //方法2：实现Runnable接口
        System.out.println("创建线程方法2：实现Runnable接口");
        Runnable runnable1=new MyRunnable();//这个创建一个，表明了数据的共享性
        Thread t3=new Thread(runnable1,"线程A");
        Thread t4=new Thread(runnable1,"线程B");
        t3.start();
        t4.start();


//        //如果采用这种方法来创建线程，Runnable仍然不可以实现数据共享，这种方式就相当于我们继承Thread来创建线程
//        System.out.println("创建线程方法2：实现Runnable接口");
//        Runnable runnable1=new MyRunnable();//这个创建一个，表明了数据的共享性
//        Runnable runnable2=new MyRunnable();
//        Thread t3=new Thread(runnable1,"线程A");
//        Thread t4=new Thread(runnable2,"线程B");
//        t3.start();
//        t4.start();
    }
}
