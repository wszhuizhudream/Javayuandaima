package cn.kbt.kk;

public class Test {
public static void main(String[] args) {
	MyThread t1=new MyThread();
	MyThread t2=new MyThread();
t1.start();
t2.start();
//只有一条线程在执行
//t1.run();
//t2.run();
}
}
