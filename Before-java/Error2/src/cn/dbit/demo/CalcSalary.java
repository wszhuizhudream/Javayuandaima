package cn.dbit.demo;

import java.util.Scanner;

public class CalcSalary {
	public static void main(String[] args) {
		int base;     		 //��������
        double ga;           //��۽���
        double hra;          //���ݽ���
        double salary;       //нˮ
        
        System.out.println("������������ʣ�");
        Scanner input = new Scanner(System.in);
        base = input.nextInt();
        
        ga = base * 40 / 100;
        hra = base * 25 /100;
        salary = base + ga + hra; 
        
        /*�������ϸĿ*/
        System.out.println("��Ա���Ĺ���ϸĿΪ�� ");
        System.out.println("��������Ϊ�� " + base);
        System.out.println("��۽���Ϊ�� " + ga);
        System.out.println("�������Ϊ�� " + hra);
        System.out.println("Ա��нˮ�ǣ� " + salary);
}
}
