package com.bittech.pool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: secondriver
 * Created: 2019/1/12
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestTimer {
    
    public static void main(String[] args) {
        Timer timer  = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行："+System.currentTimeMillis());
            }
        },1000,500);
        
    }
}
