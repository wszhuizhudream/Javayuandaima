package cn.baozhuang.www;

import java.awt.List;


/*
 * java当中除了八中基本数据类型以外的所有的类都是Object的子类
 * 包装类：
 * 装箱：把基本数据类型转换成对象
 * 拆箱：把对象转换成基本数据类型
 */
public abstract class Test {
public static void main(String[] args) {
	//有两种装箱方式：
	/*1.以下两行将基本数据类型转换就叫装箱（自动装箱）
	int i=10;
	Integer ing=i;//Integer就是int的包装类，就把它当做int使用
	      //两者区别：一个是类，一个是基本数据类型
	     //Integer是对int的包装类
	      */
	/*2.通过new Integer()的方式将i进行装箱
	int i=3;
	Integer ing1=new Integer(i);
	System.out.println(i);
	System.out.println(ing);
	*/
	//List a=new ArrayList();
	//Integer的两种写法，这两种赋值方式仅限于8种基本数据类型和String
	Integer ing1=20;
	Integer ing2=new Integer(30);
	//或者写为Integer ing2=new Integer(ing1);
	String name="你好";
	String name1=new String("你说呢");
	//注意：String不是8种基本数据类型，是密封类（final）
	/*
	 * 拆箱的两种方式：
	 * 1.直接对象调方法
	 * Integer ing=new Integer(10);
	 * int num =ing.intValue();
	 * System.out.println(num);
	 * 2.直接赋值
	 * int num1=ing;
	 * System.out.println(num1);
	 */
	//将一个字符串数字转换成int型
	//能用类命调用的方法一定是静态方法
	int b=Integer.parseInt("100");//parseInt():转的是String类型的数字，不能放汉字
	Integer a1=Integer.parseInt("100");//自动转换
	System.out.println(b);
	/*
	 * double型
	 * b=2.16473223
	 * Double b1=
	 */
	/*
	 * float型
	 */
	/*
	 * boolean型
	 */
	/*
	 * short型
	 */
	/*
	 * long型
	 * Long l=22（错误，因为程序自动认为这是int型，应该用int相关的数据类型或包装类接收
	 * Long l1=22l(正确)
	 */
	/*char型
	 * ch
	char c='a';
	Character ch=c;
	Character ch1=new Character(ch);
	System.out.println(ch);
	System.out.println(ch1);
	*/
	
	/*byte型
	byte by=11;
	Byte b1=33;
	Byte b2=new Byte(44);（现在认为44是int类型，这个括号里面的数据类型要和
	                    构造方法一致。）
	 */
	
	
	
	
}
}
