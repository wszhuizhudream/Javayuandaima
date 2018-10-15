package cn.kbt.kk;

public class Test7 {
public static void main(String[] args) {
	Site site = new Site();
	Thread s1=new Thread(site,"ºÃÓÑÇÀÆ±");
	Thread s2=new Thread(site,"QQÇÀÆ±");
	Thread s3=new Thread(site,"Î¢ÐÅÇÀÆ±");
	System.out.println("------¿ªÊ¼ÇÀÆ±------");
	s1.start();
	s2.start();
	s3.start();
}
}
