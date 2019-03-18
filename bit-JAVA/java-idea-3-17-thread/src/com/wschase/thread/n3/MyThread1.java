package com.wschase.thread.n3;

import javafx.scene.control.TableRow;

/**三、多线程的常用操作方法
 * Author:WSChase
 * Created:2019/3/18
 */
public class MyThread1 implements Runnable{


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("当前线程："+Thread.currentThread().getName()+",i="+i);
        }
    }
}
