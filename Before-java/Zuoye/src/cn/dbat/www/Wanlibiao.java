package cn.dbat.www;

import java.util.Scanner;

public class Wanlibiao {
	public static void main(String[] args){
		int years=0;
		int month=0;
		int days=0;
		boolean a=false;
		Scanner input = new Scanner(System.in);
		//如果需要从运行界面输入在一个程序中
        //只需要一个Scanner input = new Scanner(System.in);
       //等到需要输入时只要用对应类型a=input.nextInt();即可
		System.out.println("请输入年份：");
		 years=input.nextInt();
		System.out.println("请输入月份：");
		 month=input.nextInt();
		 System.out.println(years+"年"+month+"月日历表");
		if((years%4==0&&years%100!=0)||(years%400==0))
		{
			a=true;
		}
		int totaldays=0;//累计天数
		for(int i=1998;i<years;i++){
			if((i%4==0&&i%100!=0)||(i%400==0)){
				totaldays+=366;
			}
			else{
				totaldays+=365;
				}
		}
		int beforedays=0;//根据月份判断天数 
		for(int j=1;j<=month;j++){
		switch(j)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		days=31;
		break;
		case 4:
		case 6:
		case 9:
		case 11:
	    days=30;
		break;
		case 2:
			if(a)
				{days=29;}
			else
			{days=28;}
		default:
			System.out.println("输入月份不正确！");
		}
		if(j<month){
			beforedays=beforedays+days;
		}
		}
		totaldays=totaldays+beforedays;
		int firstdayofmonth=0;
		int temp=1+totaldays%7;
		if(temp==7){
			firstdayofmonth=0;
		}else{
			firstdayofmonth=temp;
		}
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int k=0;k<firstdayofmonth;k++){
			System.out.println("\t");
	      }
		for(int m=1;m<=days;m++){
			System.out.print(m+"\t");
			if((totaldays=m)%7==6){
				System.out.print("\n");
			}
		}	
	}
}

