package cn.renull.cbb;

public class Men extends Person{
	int b;
	Men()
	{
		b=20;
		System.out.println("����ǹ�����");
		}
	public static void main(String[] args) {
		Men m=new Men();
		System.out.println(m.a +" "+m.b);
	}
}
