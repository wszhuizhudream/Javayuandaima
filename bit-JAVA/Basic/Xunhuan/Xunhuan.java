//1. public class Xunhuan{
	// public static void main(String[] args){
// int line = 10;
// for(int x=0;x<line;x++){//控制行数
	// for(int y=0;y<line-x;y++){//控制空格数
		// System.out.print(" ");
	// }
	// for (int z=0;z<x;z++){
		// System.out.print("* ");
	// }
// for(int x=0;)
	// for(int m=0;m<x;m++){
		// System.out.print(" ");
	// }
	// for (int n=0;n<line-x;n++){
		// System.out.print("* ");
	// }
	// System.out.println();
       // }
   // }
// }

//2.switch范例
// import java.io.IoException;
// public class Xunhuan{
	// public static void mian (String[] args){
		// System.out.println("请输入字符：");
		// char x = (char) System.out.read();
		// switch(x){
			// case 'a':{
				// System.out.println("输入的是a!");
				// break;
			// }
			// case 'b':{
				// System.out.println("输入的是b!");
				// break;
			// }
			// default:{
				// System.out.println("输入错误！");
			// }
		// }
	// }
// }

// 3.//java中方法的定义与使用
// public class Xunhuan{
	// public static void main(String[] args){
		// System.out.println(add(5,5));
	// }
	// public static int add(int num1,int num2){
		// int result = num1+num2;
		// return result;
	// }
// }


// //4.if分支
// public class Xunhuan{
	// public static void main(String[] args){
		// myPrint(1);
		// myPrint(2);
	// }
	// public static void myPrint(int num){
		// if(num==2){
			// return;
		// }else{
			// System.out.println(num);
		// }
	// }
// }


// //5.方法重载
// public class Xunhuan{
	// public static void main(String[] args){
		// System.out.println(add(5,5));//两个参数
		// System.out.println(add(5,5,5));//三个参数，参数类型相同
	// }
	// public static int add(int num1,int num2){
		// int result=num1+num2;
		// return result;
	// }
	// public static int add(int num1,int num2,int num3){
		// int result = num1+num2+num3;
		// return result;
	// }
// }

// //6.方法递归
// public class Xunhuan{
	// public static void main(String[] args){
		// System.out.println(sum(30));
	// }
	// public static int sum(int num){
		// if(num==1){
			// return 1;//这个相当于是递归出口，在一个递归函数中，递归出口就是那种特殊情况，不运算可以直接得到结果。
		// }else{
			// return num+sum(num-1);
		// }
	// }
// }


// //7.实现60的阶乘
// public class Xunhuan{
	// public static void main(String[] args){
		// long result=(long) fac(60);
		// System.out.println(result);
	// }
	// public static long fac(long num){
		// if(num==1L){
			// return 1;
		// }else{
			// return num*fac(num-1);
		// }
	// }
// }






















