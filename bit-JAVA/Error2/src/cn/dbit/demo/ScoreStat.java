package cn.dbit.demo;

import java.util.Scanner;

public class ScoreStat {
public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("STB�ĳɼ��ǣ�");
	int stb=input.nextInt();
	System.out.print("Java�ĳɼ��ǣ�");
	int java=input.nextInt();
	System.out.print("SQL�ĳɼ��ǣ�");
	int sql=input.nextInt();
	int diffen;
	double avg;
	System.out.println("--------------");
	System.out.println("STB\tJava\tSQL");
	System.out.println(stb+"\t"+java+"\t"+sql);
	System.out.println("--------------");
	diffen=java-sql;
	System.out.println("Java��SQL�ĳɼ��"+diffen);
	avg=(stb+java+sql)/3;
	System.out.println("3�ſε�ƽ�����ǣ�"+avg);	
    }
}
