package cn.kbt.kk;

public class Test7 {
public static void main(String[] args) {
	Site site = new Site();
	Thread s1=new Thread(site,"������Ʊ");
	Thread s2=new Thread(site,"QQ��Ʊ");
	Thread s3=new Thread(site,"΢����Ʊ");
	System.out.println("------��ʼ��Ʊ------");
	s1.start();
	s2.start();
	s3.start();
}
}
