package com.wschase.suo;

/**
 * Author:WSChase
 * Created:2019/1/10
 */
public class TestThreadLocal {

    //多线程共享
    private static String staticCommValue;

    //多线程独立
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        //main方法是在Thread - main 线程中执行
        //1.主线程中修改staticCommValue
        staticCommValue = "这是main线程修改的值";
        //2.在主线程中修改threadLocal
        threadLocal.set("这是main线程修改的threadLocal的值");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //3.子线程中修改staticCommValue
                staticCommValue = "这是子线程修改的值";
                //4.在子线程中修改threadLocal
                threadLocal.set("这是子线程修改的threadLocal的值");

                System.out.println("子线程"+threadLocal.get());
            }
        },"子线程");

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
             e.printStackTrace();
        }

        //打印输出
        System.out.println(staticCommValue);
        System.out.println(threadLocal.get());
    }
}
