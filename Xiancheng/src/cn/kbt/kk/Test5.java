package cn.kbt.kk;

public class Test5 {
public static void main(String[] args) {
	ClimbThread s1=new ClimbThread("年轻人",500,1);
	ClimbThread s2=new ClimbThread("老年人",1500,1);
	System.out.println("开始爬山：");
	s1.start();
	s2.start();
}
}
