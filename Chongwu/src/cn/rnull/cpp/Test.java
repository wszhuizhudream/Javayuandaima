package cn.rnull.cpp;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	String no,Brand,mtype,type;
	int seatCount,days,rent;
	Car car;
	Bus bus;
	Scanner input = new Scanner(System.in);
	System.out.println("��ӭ�������������޹�˾��");
	System.out.println("������Ҫ���޵�������");
	days=input.nextInt();
	System.out.println("������Ҫ���޵��������ͣ�1������      2���ͳ�����");
	mtype=input.next();
	if ("1".equals(mtype)){
		System.out.println("������Ҫ���޵�����Ʒ�ƣ�1������   2����ˣ���");
		Brand=input.next();
		System.out.println("������γ��ͺ�");
		if("1".equals(Brand))
			System.out.println("1��550i:");
		else
			System.out.println("2�������GL8 3��������");
			type=input.next();	
			no="��BK5543";//�������ֱ��ָ�������ƺ�
			System.out.println("��������������ƺ���:"+no);
			car =new Car(no,Brand,type);
			rent=car.CalRent(days);
		}
		else{
			System.out.print("������Ҫ���޵Ŀͳ�Ʒ�ƣ�1���� 2��������:");
			Brand=input.next();
			System.out.print("������ͳ�����λ��:");
			seatCount=input.nextInt();
			no="��AU8769";//�������ֱ��ָ�������ƺ�
			System.out.println("��������������ƺ���:"+no);
			bus=new Bus(no,Brand,seatCount);
			rent=bus.CalRent(days);
		}		
		System.out.println("\n�˿����ã�����Ҫ֧�������޷�����"+rent+"��");
			
}
}
