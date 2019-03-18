package com.wschase.thread.n3;

/**处理休眠操作
 * Author:WSChase
 * Created:2019/3/18
 */
class My implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+Thread.currentThread().getName()+",i="+i);
        }
    }
}
public class MyThread2{


    public static void main(String[] args) {

        My m=new My();
        new Thread(m).start();
        new Thread(m).start();
    }
}
