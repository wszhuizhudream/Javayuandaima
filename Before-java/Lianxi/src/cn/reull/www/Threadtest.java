package cn.reull.www;

public class Threadtest {
public static void main(String[] args) {
	Compute c=new Compute();
	Compute1 c1=new Compute1();
	Thread t=new Thread(c);
	Thread t1=new Thread(c1);
	t.start();
	t1.start();
}
}
