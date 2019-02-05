package com.bittech.pool;

import java.util.concurrent.Executor;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class MyExecutor implements Executor {
    
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
    
    public static void main(String[] args) {
        
        Executor executor = new MyExecutor();
        executor.execute(() -> System.out.println("Hello"));
        executor.execute(() -> System.out.println("Hello"));
        executor.execute(() -> System.out.println("Hello"));
        executor.execute(() -> System.out.println("Hello"));
        executor.execute(() -> System.out.println("Hello"));
        
    }
}
