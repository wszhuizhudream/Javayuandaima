package cn.shuju.java;

import java.io.IOException;

//本节目标
//1.java标识符与关键字
//2.java数据类型划分
//3.java运算符
//对于类和变量的命名，java的标准命名规范为“驼峰”命名法
//对于类名，类名是以大写字母开头的名词；如果类名由多个单词组成，
//则每个单词的首字母大写。并且，源文件的文件名与公共类的名字相同。
//对于变量，如果只含有一个单词则全部小写；如果变量名由多个单词组成
//则从第二个单词开始，每个单词的首字母大写。
public class DataType {
//	public int a;
public static void main(String[] args) throws IOException {
//	int num1=10;
//	int num2=10;
//	int num=0;
//	num=num1+num2;
//	System.out.println("计算结果为："+num);
//	System.out.println(11+1l);
	
//数据类型的强转（丢失）
//	long num=2147483648l;
//	int result=(int)num;
//	System.out.println(result);
	
//重要说明
//关于数据默认值，数据默认值在main方法中无效
	
//	int num;
//	System.out.println(num);
//程序报错：num未初始化
//各个数据的默认值需要结合类才能看到
	
//	DataType d1=new DataType();
//	System.out.println(d1.a);//可以看到默认值
	
	
	
//	int i=300;
//	byte b=(byte)i;
//	System.out.println(b);
	
	
//	float f1=1.1f;
//	double a=1.1*1.1;
//	System.out.println(a);
	
//字符型与整型的转换
//	char c='A';
//	int a=c;//小类型转化为大类型，自动转化
//	System.out.println(a);
//	//大写字母 （A-Z）：65——90
//	//小写字母 （a-z）：97——122
//	//int型转化为char类型需要强转化
//	//java中使用Unicode编码（一般其他语言采用ASCII码），使用
//	//16进制编码，可以保存任何文字信息（包含中文），因此java对字
//	//符的特性支持比较好。
	
//	int num1=10;
//	double num2=10.5;
//	String num="计算结果"+num1+num2;//在String类型下“+”
//	                              //都是链接符号；
//	String num3="计算结果"+(num1+num2);
//	System.out.println(num);
//	System.out.println(num3);
	
//	System.out.println("5"+2);
	
	
	
	
	
	
//3-JavaSE之程序逻辑控制和方法的定义
//	int line=10;
//	for(int x=0;x<line;x++){
//		for(int y=0;y<line-x;y++){
//			System.out.println(" ");
//		}
//		for(int z=0;z<x;z++){
//			System.out.println("* ");
//		}
//		System.out.println();
//	}
	
	

//switch范例
//	System.out.println("请输入字符：");
//	char x=(char)System.in.read();
//	switch(x){
//	case 'a':{
//		System.out.println("我还能拿我");
//	}
//	case 'b':{
//		System.out.println("书看那些");
//	}
//	default:{
//		System.out.println("可买可联系");
//	}
//   }
	//循环使用规则：
	//1.对于不知道循环执行次数，但是知道循环结束条件的，使用while
	//2.明确知道循环次数的用for循环
	
	
//2练习
////1.使用for循环打印乘法口诀表
//	for(int i=1;i<10;i++)
//	{for(int j=1;j<=i;j++)
//	{
//		int s=i*j;
//		System.out.print(i+"*"+j+"="+s+" ");
//	}
//	System.out.println();
//	}
	
	
//2.递归实现60！
	System.out.println(factorial(60));
  }
public static int factorial(int num){
	if (num==1){
		return num;
	}else{
	return num*factorial(num-1);
	}
}
}

