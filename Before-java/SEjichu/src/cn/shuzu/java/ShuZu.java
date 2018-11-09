package cn.shuzu.java;

public class ShuZu {
public static void main(String[] args) {
	int[] x=new int[3];//开辟一个长度为3的数组
	System.out.println(x.length);
	x[0]=1;//赋值
	x[1]=2;
	x[2]=3;
	for(int i=0;i<x.length;i++){
		System.out.println(x[i]);//输出
	}
}
}
