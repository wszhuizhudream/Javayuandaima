package cm.nianxi.pingshi;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Master master=new Master("������",100);
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ����������꣡");
		System.out.println("��ѡ��Ҫ�����ĳ������ͣ���1������ 2����죩");
		int typeId=input.nextInt();
		Pet pet=master.getPet(typeId);
		if(pet!=null){
			System.out.println("�����ɹ���");
			master.feed(pet);
		}else{
			System.out.println("�Բ���û�д����͵ĳ������ʧ��");
		}
	}
}
