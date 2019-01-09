package com.wschase.thread2;

/**
 * Author:WSChase
 * Created:2019/1/9
 */
class MyThread implements Runnable {
//    public static void code1(){
//        //同步块
//        private int ticket = 10; // 一共十张票
//
//        @Override
//        public void run() {
//
//            for (int i = 0; i < 10; i++) {
//                //在同一时间，只允许一个线程进入代码块
//                System.out.println("----");//如果没有这一句话，一旦有一个进入到循环里面占用了资源那么就会一直在里面
//                //但是加上这一句话以后就可以同时有多个线程进入到这个循环里面，所以运行的结果
//                //才是有A,有B，有C。
//                synchronized (this) {
//                    if (this.ticket > 0) {
//                        try {
//
//                            Thread.sleep(200);
//
//                        } catch (InterruptedException e) {
//
//                            //TODO Auto-generated catch block
//                            e.printStackTrace();
//                        } // 模拟网络延迟
//                        System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket-- + " 张票");
//                    }
//                }
//            }
//        }
//    }
    private int ticket = 10; // 一共十张票

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("---");
            this.sale();
        }
    }
     public synchronized void sale() {
         if (this.ticket > 0) {
             try {

                 Thread.sleep(200);

             } catch (InterruptedException e) {

                 //TODO Auto-generated catch block
                 e.printStackTrace();
             } // 模拟网络延迟
             System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket-- + " 张票");
         }
     }
}


public class MyRunnable {
    public static void main(String[] args) {
        MyThread mt = new MyThread() ;
        new Thread(mt,"黄牛A").start();
        new Thread(mt,"黄牛B").start();
        new Thread(mt,"黄牛C").start();
         }
     }
