package com.wschase.threadchi;

import java.util.concurrent.Executor;

/**实现线程池
 * Author:WSChase
 * Created:2019/1/13
 */
public class MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {

        //在main方法中并没有创建线程但是我们用到的是线程

        Executor executor=new MyExecutor();
        executor.execute(()-> System.out.println("h ello"));


    }
}
