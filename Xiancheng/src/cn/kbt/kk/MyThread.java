package cn.kbt.kk;

public class MyThread extends Thread {
	//��дrun
public void run(){
	for (int i = 0; i < 28; i++) {
		System.out.println(Thread.currentThread().getName()+"--->"+i);
	}
} 
}
