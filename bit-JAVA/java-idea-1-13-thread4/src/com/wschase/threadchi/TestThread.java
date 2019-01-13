package com.wschase.threadchi;

/**线程池
 * Author:WSChase
 * Created:2019/1/13
 */
public class TestThread {
    //如果像这样一直无限制的创建线程，那么最终电脑肯定会崩溃的。
    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
            }).start();
        }
    }
}
