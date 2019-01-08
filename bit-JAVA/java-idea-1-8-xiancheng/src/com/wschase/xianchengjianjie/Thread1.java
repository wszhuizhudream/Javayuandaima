package com.wschase.xianchengjianjie;

/**1.进程与线程
 * （1）通过继承Thread类实现多线程 ：用继承Thread的这个类来创建线程对象，我们可以根据自己的需要覆写这个子类的构造方法
 * （2）Thread的run方法不会启动线程，只是普通的方法调用
 * （3）Thread的start方法启动线程 ，start方法只需要调用一次
 * Author:WSChase
 * Created:2019/1/8
 */
public class Thread1 extends  Thread{
        public final String title;

    public Thread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        //多线程处理的业务逻辑
        for (int i=0;i<10;i++){
            System.out.println(this.title+" "+i);
        }
    }

    public static void main(String[] args) {

        //注意：下面的执行是按照顺序执行的，run方法只是一个普通方法，它不能启动线程
       //注意：先启动的不一定先执行，它们都在就绪状态。
        Thread1 thread1=new Thread1("线程1");
        //thread1.run();
        thread1.start();

         Thread1 thread11=new Thread1("线程2");
         //thread11.run();
        thread11.start();

    }
}
