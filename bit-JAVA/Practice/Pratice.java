public class Pratice{
	public static void main(String[] args){
		int num1=2;
		int num2=3;
		//不使用第三方变量——》法一
		// num1=num1^num2;
		// num2=num1^num2;
		// num1=num1^num2;
		// System.out.println(num1+","+num2);
		
		// //不使用第三方变量——》法二
		// num2=num1+num2;
		// num1=num2-num1;
		// num2=num2-num1;
		// System.out.println(num1+","+num2);
		
		// //使用第三方变量
		// int num3=num1+num2;
		// num2=num1;
		// num1=num3-num2;
		// System.out.println(num1+","+num2);
		//System.out.println(exchange(num1,num2));
		
	}
// public static void exchange(int num1,int num2){
	// int num3=num1+num2;
		// num2=num1;
		// num1=num3-num2;
// }
}