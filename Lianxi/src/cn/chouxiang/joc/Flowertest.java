package cn.chouxiang.joc;

public class Flowertest {
	public static void main(String[] args) {
		Flower1 f1=new Flower1();
		Flower1 f2=new Flower1();
		f1.setcolor("��ɫ");
		f1.setname("ĵ��");	
		f1.setCountry("�й�");
		f1.setCity("����");
		f2.setcolor("��ɫ");
		f2.setname("õ��");	
		f2.setCountry("����");
		f2.setCity("��˹ά��˹");
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}
}
