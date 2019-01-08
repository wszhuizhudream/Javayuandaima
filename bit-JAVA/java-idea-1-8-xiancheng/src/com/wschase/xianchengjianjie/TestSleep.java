package com.wschase.xianchengjianjie;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Author:WSChase
 * Created:2019/1/8
 */
public class TestSleep {
    public static void main(String[] args) {
        //最简洁的写法
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);//单位是毫秒
                    System.out.println("当前时间"+LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-A").start();
    }
}
