package cn.dbat.www;

import java.util.Scanner;

public class Wanlibiao {
	public static void main(String[] args){
		int years=0;
		int month=0;
		int days=0;
		boolean a=false;
		Scanner input = new Scanner(System.in);
		//�����Ҫ�����н���������һ��������
        //ֻ��Ҫһ��Scanner input = new Scanner(System.in);
       //�ȵ���Ҫ����ʱֻҪ�ö�Ӧ����a=input.nextInt();����
		System.out.println("��������ݣ�");
		 years=input.nextInt();
		System.out.println("�������·ݣ�");
		 month=input.nextInt();
		 System.out.println(years+"��"+month+"��������");
		if((years%4==0&&years%100!=0)||(years%400==0))
		{
			a=true;
		}
		int totaldays=0;//�ۼ�����
		for(int i=1998;i<years;i++){
			if((i%4==0&&i%100!=0)||(i%400==0)){
				totaldays+=366;
			}
			else{
				totaldays+=365;
				}
		}
		int beforedays=0;//�����·��ж����� 
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
			System.out.println("�����·ݲ���ȷ��");
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
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
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

