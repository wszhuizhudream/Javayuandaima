package cn.baozhuang.www;

public class Demo {
public static void main(String[] args) {
	int i=10;
	info(i);
	System.out.println(i);
}
public static void info(int i){
	System.out.println(i);
	i=50;
	System.out.println(i);
}
}
