package cn.kbt.kk;

public class Test5 {
public static void main(String[] args) {
	ClimbThread s1=new ClimbThread("������",500,1);
	ClimbThread s2=new ClimbThread("������",1500,1);
	System.out.println("��ʼ��ɽ��");
	s1.start();
	s2.start();
}
}
