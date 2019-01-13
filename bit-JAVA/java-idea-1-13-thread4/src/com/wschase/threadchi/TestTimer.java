package com.wschase.threadchi;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行："+System.currentTimeMillis());
            }
        },1000,500);
    }
}
