package cn.kbt.kk;

public class Test2 {
public static void main(String[] args) {
	Thread1 t1=new Thread1();
	t1.start();
	Thread1 t2=new Thread1();
	t2.start();
}
}
