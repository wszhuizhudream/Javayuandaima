package com.wschase.thread2;

/**线程停止
 * Author:WSChase
 * Created:2019/1/9
 */
//    //1.通过标记位的方式让线程终止
//public class TestThread {
//    public static void main(String[] args) {
//
//        MyRunnable myRunnable=new MyRunnable();
//        Thread thread=new Thread(new MyRunnable(),"子线程");
//        thread.start();
//
//    //主线程休眠
//        try {
//            Thread.sleep(3000);
//
//            //1.修改标记为-->当我们的这个标记为等到3以后就会终止线程
//            myRunnable.setFlag(false);
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class MyRunnable implements Runnable{
//
//    private boolean flag=true;
//    @Override
//    public void run() {
//        int i=0;
//        while(this.flag){
//            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i+"次");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//}






//2.通过中断让线程停止
public class TestThread {
    public static void main(String[] args) {

        MyRunnable2 myRunnable2=new MyRunnable2();
        Thread thread=new Thread(new MyRunnable2(),"子线程");
        thread.start();

        //主线程休眠
        try {
            Thread.sleep(3000);
            //Thread的中断方法
            thread.interrupt();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i+"次");
            try {

                //判断线程的中断情况
                boolean interruptedStatus = Thread.currentThread().isInterrupted();
                //非阻塞情况
                if(interruptedStatus){
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断："+Thread.currentThread().isInterrupted());
                return;
            }
        }
    }
}

