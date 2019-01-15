package com.wschase.thread1;

/**第二节：线程的创建
 * Author:WSChase
 * Created:2019/1/14
 */
        //线程的创建总共有3种方法
        //1.通过继承Thread类创建线程
public class CreateThreadMethod1 extends Thread {
    private String name;

    //无参构造方法
    public CreateThreadMethod1(){

    }

    //含参构造方法
    public CreateThreadMethod1(String name) {
        setName(name);
    }

    //实现线程需要实现的逻辑
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("当前运行的线程"+getName()+",i="+i);
        }
    }

    public static void main(String[] args) {
        //在主方法中创建线程并且启动线程
        //因为我们的构造方法有含参构造，所以我们在使用自己定义的继承了Thread的类来创建
        //线程的时候，我们选择的含参构造，传入一个参数（线程名)，创建线程成功
        CreateThreadMethod1 t1=new CreateThreadMethod1("线程1");
        CreateThreadMethod1 t2=new CreateThreadMethod1("线程2");

        //创建完线程以后，它是处于就绪状态的，需要我们启动，使用start()方法启动线程
        t1.start();
        //t1.start();
        //我们需要注意，通过继承Thread类来实现线程的创建。创建以后线程只能启动一次，不可以多次启动。
        // 因为Thread类的单继承。
        t2.start();

    }
}
