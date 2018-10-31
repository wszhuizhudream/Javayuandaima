package cm.abc.yichang;

import java.util.Scanner;

public class Yichang {
public static void main(String[] args) {
	System.out.println("请输入课程号（1~3之间的数字）：");
	Scanner in = new Scanner(System.in);
	try{
		int courseCode = in.nextInt();
		switch(courseCode){
		case 1:
			System.out.println("数学");
			return;
		case 2:
			System.out.println("语文");break;
		case 3:
			System.out.println("英语");
		}
	}catch(Exception e){
		System.out.println("输入不为数字！");
		e.printStackTrace();
	}finally{
		System.out.println("欢迎提出建议");
	}
}
}
