package cn.reun.com;
import java.util.Scanner;

public class Tiaojian {
public static void main(String[] args)
{
	int m;
	System.out.println("������ƽ���ɼ���");
	Scanner input = new Scanner(System.in);
	m=input.nextInt();
	if((m>90)&&(m<=100))
	{
		System.out.println("���ѧ��Ӧ��A��������");
	}
	else if((m>80)&&(m<=90))
	{
		System.out.println("���ѧ��Ӧ��B��������");
	}
	else if((m>70)&&(m<=80))
	{
		System.out.println("���ѧ��Ӧ��C������");
	}
	else if((m>60)&&(m<=70))
	{
		System.out.println("���ѧ��Ӧ��C���Ǻϸ�");
	}
	else
	{
		System.out.println("���ѧ��Ӧ��D���ǲ��ϸ�");
	}
}
}
