package com.wschase.thread.n3;


/**设置标记位使线程退出
 * Author:WSChase
 * Created:2019/3/18
 */

class Mythread3 implements Runnable{

    //标记位
    private boolean flag=true;
    @Override
    public void run() {
        int i=1;
        while(flag){
            try {
                Thread.sleep(1000);
                System.out.println("第"+i+"次执行，线程名称为："+Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        public void setFlag(boolean flag){
            this.flag=flag;
    }
}
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Mythread3 mythread3=new Mythread3();
        Thread thread1=new Thread(mythread3,"子线程");
        thread1.start();
        Thread.sleep(2000);
        mythread3.setFlag(false);
        System.out.println("代码结束");
    }

}
