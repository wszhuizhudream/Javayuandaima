package cn.reun.com;
import java.util.Scanner;

public class Tiaojian {
public static void main(String[] args)
{
	int m;
	System.out.println("请输入平均成绩：");
	Scanner input = new Scanner(System.in);
	m=input.nextInt();
	if((m>90)&&(m<=100))
	{
		System.out.println("这个学生应得A，是优秀");
	}
	else if((m>80)&&(m<=90))
	{
		System.out.println("这个学生应得B，是良好");
	}
	else if((m>70)&&(m<=80))
	{
		System.out.println("这个学生应得C，是良");
	}
	else if((m>60)&&(m<=70))
	{
		System.out.println("这个学生应得C，是合格");
	}
	else
	{
		System.out.println("这个学生应得D，是不合格");
	}
}
}
