package cm.abc.yichang;

import java.util.Scanner;

public class Yichang {
public static void main(String[] args) {
	System.out.println("������γ̺ţ�1~3֮������֣���");
	Scanner in = new Scanner(System.in);
	try{
		int courseCode = in.nextInt();
		switch(courseCode){
		case 1:
			System.out.println("��ѧ");
			return;
		case 2:
			System.out.println("����");break;
		case 3:
			System.out.println("Ӣ��");
		}
	}catch(Exception e){
		System.out.println("���벻Ϊ���֣�");
		e.printStackTrace();
	}finally{
		System.out.println("��ӭ�������");
	}
}
}
