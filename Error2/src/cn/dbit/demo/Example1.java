package cn.dbit.demo;

public class Example1 {
	public static void main(String[] args){
		int num=8461;
		int gewei=num%10;
		int shiwei=num/10%10;
		int baiwei=num/100%10;
		int qianwei=num/1000;
		System.out.println("���֣�"+num);
		System.out.println("ǧλ���ǣ�"+qianwei);
		System.out.println("��λ���ǣ�"+baiwei);
		System.out.println("ʮλ���ǣ�"+shiwei);
		System.out.println("��λ���ǣ�"+gewei);
	}
}
