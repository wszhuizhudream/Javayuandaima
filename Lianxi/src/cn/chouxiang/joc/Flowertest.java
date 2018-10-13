package cn.chouxiang.joc;

public class Flowertest {
	public static void main(String[] args) {
		Flower1 f1=new Flower1();
		Flower1 f2=new Flower1();
		f1.setcolor("红色");
		f1.setname("牡丹");	
		f1.setCountry("中国");
		f1.setCity("沈阳");
		f2.setcolor("黄色");
		f2.setname("玫瑰");	
		f2.setCountry("美国");
		f2.setCity("拉斯维加斯");
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}
}
