package cn.qiche.zulin;

import java.util.Scanner;

public class Testrent {
	public static void main(String[] args) {
		String no,brand,type,mtype;
		int seatCount,days,rent;
		Car car;
		Bus bus;
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎来到汽车租赁公司！");
		System.out.println("请输入要租赁的天数：");
		days=input.nextInt();
		System.out.println("请输入要租赁的汽车类型(1、轿车  2、客车):");
		mtype=input.next();
		
	}
}
