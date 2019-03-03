package cn.rnull.cpp;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	String no,Brand,mtype,type;
	int seatCount,days,rent;
	Car car;
	Bus bus;
	Scanner input = new Scanner(System.in);
	System.out.println("欢迎您来到汽车租赁公司！");
	System.out.println("请输入要租赁的天数：");
	days=input.nextInt();
	System.out.println("请输入要租赁的汽车类型（1：汽车      2：客车）：");
	mtype=input.next();
	if ("1".equals(mtype)){
		System.out.println("请输入要租赁的汽车品牌（1、宝马   2、别克）：");
		Brand=input.next();
		System.out.println("请输入轿车型号");
		if("1".equals(Brand))
			System.out.println("1、550i:");
		else
			System.out.println("2、商务舱GL8 3、林荫大道");
			type=input.next();	
			no="京BK5543";//简单起见，直接指定汽车牌号
			System.out.println("分配给您的汽车牌号是:"+no);
			car =new Car(no,Brand,type);
			rent=car.CalRent(days);
		}
		else{
			System.out.print("请输入要租赁的客车品牌（1、金杯 2、金龙）:");
			Brand=input.next();
			System.out.print("请输入客车的座位数:");
			seatCount=input.nextInt();
			no="京AU8769";//简单起见，直接指定汽车牌号
			System.out.println("分配给您的汽车牌号是:"+no);
			bus=new Bus(no,Brand,seatCount);
			rent=bus.CalRent(days);
		}		
		System.out.println("\n顾客您好！您需要支付的租赁费用是"+rent+"。");
			
}
}
