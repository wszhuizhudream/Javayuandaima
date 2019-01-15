package com.wschase.thread1;

/**第二节：线程的创建方法2
 * Author:WSChase
 * Created:2019/1/14
 */
public class CreateThreadMethod2 implements Runnable{
    //2.创建线程的第二种方法——实现Runnable接口

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //无参构造
     public CreateThreadMethod2(){

     }

    //含参构造
    public CreateThreadMethod2(String name) {
        setName(name);
    }

    //线程需要实现的逻辑业务
    //相当于是我们的线程创建并且启动以后，它们需要干的事情就是执行这个逻辑业务
    @Override
    public void run() {

        for(int i=1;i<10;i++){
            System.out.println("当前执行的线程"+getName()+",i="+i);
        }
    }

    public static void main(String[] args) {
        //创建线程:通过实现Runnable接口来创建线程我们需要通过Thread类来实现
        //但是我们需要准备一个Runnable的实现子类对象作为参数传递到Thread。

        Runnable runnable1=new CreateThreadMethod2("线程1");//实现向上转型
        Runnable runnable2=new CreateThreadMethod2("线程2");//实现向上转型


        Thread t1=new Thread(runnable1);
        Thread t2=new Thread(runnable2);
        Thread t3=new Thread(runnable2);
        t1.start();
        t2.start();
        t3.start();
    }

}
