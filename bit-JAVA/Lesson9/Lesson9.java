// 编程练习
// 1.猜数字游戏：
// 随机生成[0，100）,用户的输入数字告知是否猜中，如果不中，继续猜直到猜中
// import java.util.Scanner;
// class GuessNumber{
	// private static final int number=24;
	// java.util.Random random=new java.util.Random();
	// int values=random.nextInt(100);//随机一个区间[0,100)
	// public void guessNumber(int inputNumber){
		// while(true){
		// if(inputNumber<number){
			// System.out.println("猜小了");
		// }else if(inputNumber>number){
			// System.out.println("猜大了");
		// }else{
			// System.out.println("猜中了");
			// break;
		// }
	// }
// }
// public class Lesson9{
	// public static void main(String[] args){
		// System.ouot.println("请输入数字：");
		// Scanner scanner=new Scanner(System.in);
		// int num=Scanner.nextInt();
		// GuessNumber g1=new GuessNumber();
		// g1.guessNumber(num);
	// }
// }

// 2.快递员送花之代理模式（张三 让快递员 帮忙 送花给 女朋友 李四）
// interface SendFlower{
	// public void sendflower();
// }
// class RealSender implements SendFlower{
	// public void sendflower(){
		// System.out.println("张三送花给李四");
	// }
// }
// class ProxySender implements SendFlower{
	// private RealSender target;//真正送花的那个人
	// public ProxySender(RealSender target){
		// this.target=target;
	// }
	// public void notice(){
		// System.out.println("送花之前先打电话通知");
	// }
	// public void signIn(){
		// System.out.println("收到花以后签收");
	// }
	// public void sendflower(){
		// this.notice();//操作前的准备
		// this.target.sendflower();
		// this.signIn();
	// }
// }
// // class Factory{
	// // public static SendFlower getInstance(){
		// // return new ProxySender(new RealSender());
	// // }
// // }
// public class Lesson9{
// public static void main(String[] args){
	// RealSender target=new RealSender();
	// ProxySender ps=new ProxySender(target);
	// ps.sendflower();
// }
// }

// // 3.模板设计模式：在线购物流程（天猫，京东）
// //  浏览商品->选择商品->客服服务->快递服务->结算->付款->查看订单
// //将相同的行为在抽象方法中实现，将不同的行为表示为抽象方法让继承它的子类来实现
// import java.util.Scanner;
// abstract class Shop{
	// //将所有的方法分为两类，并且将公有的方法放在一起
	// final void preparePecipe(){
	// //浏览商品
	// browsegoods();
	// //选择商品
    // selectgoods();
	// //快递服务
	// expressService();
	// //结算
	// settleAccount();
	// //付款-
	// payment();
	// }
	
	// //天猫和京东对客服服务和检查订单不同，所以将他们定义为抽象类，让子类实现
	// //客服服务
	// abstract void customerService();
	// //检查订单
	// abstract void checkOrder();
	
	// //浏览商品
	// public void browsegoods(){
		// System.out.println("浏览商品");
	// }
	// //选择商品
    // public void selectgoods(){
		// System.out.println("选择商品");
	// }	
	// //快递服务
	// public void expressService(){
		// System.out.println("快递服务");
	// }
	// //结算
	// public void settleAccount(){
		// System.out.println("结算");
	// }
	// //付款-
	// public void payment(){
	// System.out.println("付款");
	// }
// }

// //天猫购物
// class TianmaoShop extends Shop{	
	// //客服服务
	// public void customerService(){
		// System.out.println("天猫客服服务");
	// }
	// //检查订单
	// public void checkOrder(){
		// System.out.println("天猫检查订单");
	// }
// }

// //京东购物
// class JingdongShop extends Shop{
	// //客服服务
	// public void customerService(){
		// System.out.println("京东客服服务");
	// }
	// //检查订单
	// public void checkOrder(){
		// System.out.println("京东检查订单");
	// }
// }
// public class Lesson9{
	// public static void main(String[] args){
		// System.out.println("请输入是进入天猫购物还是进入京东购物：");
	// Scanner scanner=new Scanner(System.in);
	// String answer=scanner.nextLine();
	// switch(answer){
	// case "天猫":{
		// TianmaoShop tianmao=new TianmaoShop();
		// tianmao.preparePecipe();
		// tianmao.customerService();
		// tianmao.checkOrder();
		// break;
	// }
	// case "京东":{
		// JingdongShop jingdong=new JingdongShop();
		// jingdong.preparePecipe();
		// jingdong.customerService();
		// jingdong.checkOrder();
		// break;
	// }
    // default:{
		// System.out.println("没有这个平台");
	// }
	// }
	// }
// }






















