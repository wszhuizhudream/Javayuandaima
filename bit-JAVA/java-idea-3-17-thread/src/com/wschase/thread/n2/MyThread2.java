package com.wschase.thread.n2;

/**Runnable接口实现多线程
 * 对于Runnable接口实现多线程，实际上还是需要我们的Thread来创建，Runnable只是中间的一个
 * 桥梁，它作为我们的Thread的参数进行传递就可以了。
 * 我们一般采用实现Runnable接口来实现多线程。Runnable接口实现的多线程是数据共享的。
 * Author:WSChase
 * Created:2019/3/17
 */
public class MyThread2 implements Runnable{
    private String title;//这个参数是线程的名称
    public MyThread2(String title){
        this.title=title;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("i="+i);
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread21=new MyThread2("thread1");
        MyThread2 myThread22=new MyThread2("thread2");
        new Thread(myThread21).start();
        new Thread(myThread22).start();
    }
}
