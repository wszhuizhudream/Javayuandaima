//1.请手写如下所示格式的个人信息 Java 代码：  Name: Mary    Post: HR Director Sex: female    Age: 26 Tel: 18081318888   Adress: DaTun road no. 6,chaoyang,Beijing 
//在静态类中不可以直接访问非静态的属性或者方法，可以通过定义一个方法，然后通过调用方法访问属性
// public class SmallTest{
	// private String name="Mary";
	// private String sex="female";
	// private String tel="18081318888";
	// private String post="HR Director";
	// private int age=26;
	// private String adress="DaTun road no.6,chaoyang,Beijing";
// public void print(){
	// System.out.println("name:"+name+",sex:"+sex+",tel:"+tel+",post:"+post+",age:"+age+",adress:"+adress);
// }
	// public static void main(String[] args){
		// SmallTest s1=new SmallTest();
		// s1.print();
	// }
// }

// 3.购物计算     
// 小明去商场购买Ｔ恤 2 件，运动鞋 1 双，网球拍 2 个，其中Ｔ恤价格为 245 元，运动鞋 价格 370 元，网球拍价格 345.5 元，
//由于商场打折，购买 2 件以上打 8 折，计算下小明一共消费了多少钱？
//这个题的注意点在数据类型的定义应该选择什么
// class Shop{
	// private int tshirtnum=2;
	// private int shoenum=1;
	// private int painum=2;
	// private int tshirtprice=245;
	// private int shoeprice=370;
	// private double paiprice=345.5;
	// public void discount(){
		// double sum;
		// sum=0.8*(tshirtnum*tshirtprice+shoenum*shoeprice+painum*paiprice);
		// System.out.println(sum);
	// }
// } 
// public class SmallTest{
	// public static void main(String[] args){
		// Shop s1=new Shop();
		// s1.discount();
	// }
// }

// 4.结算时打印购物小票 计算此次购物获得的会员积分(自定义百分比) 
//思路：价格还是和上一题一样，只是现在需要计算的是积分
//自定义积分为：所付钱*0.05；
// class Shop{
	// private int tshirtnum=2;
	// private int shoenum=1;
	// private int painum=2;
	// private int tshirtprice=245;
	// private int shoeprice=370;
	// private double paiprice=345.5;
	// public void discount(){
		// double sum;
		// int score;
		// sum=0.8*(tshirtnum*tshirtprice+shoenum*shoeprice+painum*paiprice);
		// System.out.println(sum);
		// score=(int)(sum*0.05);//强制类型转化，积分一般不会出现小数;注意用括号括起来，优先级
		// System.out.println("本次获得积分为："+score);
	// }
// } 
// public class SmallTest{
	// public static void main(String[] args){
		// Shop s1=new Shop();
		// System.out.println("需要付钱：");
		// s1.discount();
	// }
// }


// 5.交换两个数
//（1）不使用第三方变量。
// public class SmallTest{
// public static void main(String[] args){
	// int num1=10;
	// int num2=8;
	// System.out.println("交换以前的数："+num1+","+num2);
	// num1=num1^num2;
	// num2=num1^num2;
	// num1=num1^num2;
	// System.out.println("交换以后的数为："+num1+","+num2);
// }
// } 
//（2）使用第三方变量。 
// public class SmallTest{
	// public static void main(String[] args){
		// int num1=10;
		// int num2=8;
		// System.out.println("交换以前的数："+num1+","+num2);
		// int num3;
		// num3=num1;
		// num1=num2;
		// num2=num3;
		// System.out.println("交换以后的数："+num1+","+num2);
	// }
// }
 
// 6.输入本金，算出1年，2年，3年，5年后的本息是多少？（1年利息2.25/100，2 年利息为2.7/100，3年利息3.24/100，5年利息3.6/100） 
// public class SmallTest{
	// public static void main(String[] args){
	// double ONE=2.25/100;
	// double TWO=2.7/100;
	// double THREE=3.24/100;
	// double FIVE=3.6/100;
	// System.out.println("请输入要存的年数：");
	 // int num=System.in.read();
	// if(num==1){
		// System.out.println("本息为："+(ONE*num+num));
	// }else if(num==2){
		// System.out.println("本息为："+(TWO*num+num));
	// }else if(num==3){
		// System.out.println("本息为："+(THREE*num+num));
	// }else if(num==5){
		// System.out.println("本息为："+(FIVE*num+num));
	// }
	// }
// }
 
// 7.编写一个程序，根据矩形的长 length=6.9m（float 类型）和 width=10m（int 类型），计算矩形周长和面积。
//（请在周长和面积的值后面加上它们个自的单位“m”和“㎡”周长必须 为 float 类型，面积必须为 int 类型。周长=2*（长+宽）；面积=长*宽.） 
 
// public class SmallTest{
	// //被访问权限修饰的属性不可以定义到main方法中
	// private float length=6.9F;//注意float型的类型后面需要加F
		// private int width=10;
		// private float perimeter;
		// private int area;
			// public void caculate(){
			// perimeter=(float)(2*(length+width));
			// area=(int)(length*width);
			// System.out.println("周长为："+perimeter);
			// System.out.println("面积为："+area);
	// }
	// public static void main(String[] args){
		// SmallTest s1=new SmallTest();
		// s1.caculate();
	// }
// }

// 8.从控制台接收一个整数，计算出它的平方并输出 
// public class SmallTest{
 // public static void main(String[] args){
	 // int num;
	 // System.out.println("请输入一个整数计算它的平方");
	 // num=(int)System.in.read();
	 // int result=num*num;
	 // System.out.println("这个数的平方为："+result);
 // }	
// }
































































