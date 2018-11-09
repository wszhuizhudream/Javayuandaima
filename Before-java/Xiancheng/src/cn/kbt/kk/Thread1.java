package cn.kbt.kk;

public class Thread1 extends Thread {
public void run(){
	for (int i = 0; i < 20; i++) {
		System.out.println(i+"你好：来自线程"+Thread.currentThread().getName());
	}
}
}
