// //这个界面是为了显示并且呈现出交换界面
// import java.util.Scanner;
// public class CheckStand1{
	// public static void main(String[] args){
		// //首先定义一个数组来表示10个商品
		// int[] goods=new int[]{1,2,3,4,5,6,7,8,9,10};//静态初始化，边定义边赋值
		// //再定义一个数组来表示商品的状态
		// String[] state=new String[]{"--未上架","--未上架","--未上架","--未上架","--未上架","--未上架","--未上架","--未上架","--未上架","--未上架"};
		// //再定义一个数组来表示这些商品的单价
		// double[] price=new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
		// System.out.println("************欢迎使用简易收银台************");
		// System.out.println("   "+"[U] 使用"+" "+"[S] 设置"+" "+"[A] 关于"+" "+"[Q] 退出");
		// System.out.println("   "+"输入： U S A Q 进入操作");
		// System.out.println("******************************************");
		// Scanner scanner=new Scanner(System.in);
		// //用户输入字符
		// String inputChar=scanner.nextLine();//表述输入一个字符串
		// //对于输入的字符串一共要做4种情况的判断下面对于这4种情况分别进行相应的处理		
		// switch(inputChar){
			// //情况1：[U]使用——》在情况1种还会出现5种情况，然后在情况1中再进行分类
		// //并且注意我们对输入的大小写不区分
			// case "U":
			// case "u":{
			// System.out.println("************ 买单功能 ************");
		    // System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		    // System.out.println("   "+"输入： S A D L Q 进入操作");
		    // System.out.println("******************************************");
            // System.out.println("***************** 商品清单 ******************");
			// System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			// for(int i=0;i<goods.length;i++){
			// System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			// }
			// System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			// System.out.println("*********************************************");
			// //再对第一种情况的5种情况进行分类
		// //用户输入字符
		// String inputCharu=scanner.nextLine();//表述输入一个字符串
			// switch(inputCharu){
				// case "S":
				// case "s":
				// case "A":
				// case "a":
				// case "D":
				// case "d":
				// case "L":
				// case "l":
				// case "Q":
				// case "q":{
					// System.out.println("************ 买单功能 ************");
                    // System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		            // System.out.println("   "+"输入： S A D L Q 进入操作");
		            // System.out.println("******************************************");

				// }
			// }
			// break;
			// }
		// //情况2：[S]设置——》在情况2中又分了5种情况，再对这5种情况进行分析
		    // case "S":
			// case "s":{
     		// System.out.println("************ 设置功能 ************");
			// System.out.println("   "+"[S] 查看"+" "+"[A] 上架"+" "+"[D] 下架"+" "+"[U] 修改"+"[Q] 退出");
		    // System.out.println("   "+"输入： S A D U Q 进入操作");
			// String inputChars=scanner.nextLine();//表述输入一个字符串
			// switch(inputChars){
				// case "S":
				// case "s":{
            // System.out.println("***************** 商品清单 ******************");
			// System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			// for(int i=0;i<goods.length;i++){
			// System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			// }
			// System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			// System.out.println("*********************************************");
				// }
				// case "A":
				// case "a":{
					// System.out.println("请输入上架商品信息（如下格式： 1 餐巾纸 1.4）：");
					// int inputnum=scanner.nextInt();//用户输入上架商品的单号
					// String inputname=scanner.nextLine();//用户输入的上架商品名称
					// state[inputnum]=inputname;
					// double inputprice=scanner.nextDouble();//用户输入上架商品价格
				    // price[inputnum]=inputprice;
					            // System.out.println("***************** 商品清单 ******************");
			                    // System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			                    // for(int i=0;i<goods.length;i++){
			                    // System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			                // }
			                   // System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			                   // System.out.println("*********************************************");

				// }
			// }
		    // break;
		// }
		// //情况3：[A]关于
		// //不区分大小写
		    // case "A":
			// case "a":{
		    // System.out.println("***************   关于   ***************");
			// System.out.println("        "+"名称：简易收银台");
		    // System.out.println("        "+"功能：基于字符界面的收银台操作系统");
			// System.out.println("        "+"作者：secondriver");
			// System.out.println("        "+"版本:v0.0.1");
			// System.out.println("        "+"意见反馈：secondriver@yeah.net");
		    // System.out.println("******************************************");
		    // break;
		// }
		// //情况4：
		    // case "Q":
			// case "q":{
			// System.out.println("************ 欢迎使用，下次再见 ************");
			// break;
		// }
		// }
	// }
// }












//购物中心，显示商店的物品
public class GoodsCenter1{
	public void getGoods(){
		System.out.println("         "+this. goodsnum+"          "+this.goodsname+"            "+this.goodsprice);
	}
	public void print(Goods goods){
			System.out.println("************ 买单功能 ************");
		    System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		    System.out.println("   "+"输入： S A D L Q 进入操作");
		    System.out.println("******************************************");
            System.out.println("***************** 商品清单 ******************");
			System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			for(int i=0;i<goods.length;i++){
			goods[i].getGoods();
			}
			System.out.println("*********************************************");

		}

// //开辟一个对象数组
		// Goods1[] goods=new Goods[10];
		// //动态初始化
		// for(int i=0;i<goods.length;i++){
			// goods[i]=new Goods(i,"未上架",0.0);
		// }
		
	public static void main(String[] args){
		Goods1[] goods=new Goods[10];
		//动态初始化
		for(int i=0;i<goods.length;i++){
			goods[i]=new Goods(i,"未上架",0.0);
		}
	
		for(int i=0;i<goods.length;i++){
         print(goods);			
			}
	}	
		
// //打印初始界面
	// public void print(){
		// System.out.println("************欢迎使用简易收银台************");
		// System.out.println("   "+"[U] 使用"+" "+"[S] 设置"+" "+"[A] 关于"+" "+"[Q] 退出");
		// System.out.println("   "+"输入： U S A Q 进入操作");
		// System.out.println("******************************************");
		// Scanner scanner=new Scanner(System.in);
		// //用户输入字符
		// String inputChar=scanner.nextLine();//表述输入一个字符串
		// //对于输入的字符串一共要做4种情况的判断下面对于这4种情况分别进行相应的处理		
		// switch(inputChar){
			// //情况1：[U]使用——》在情况1种还会出现5种情况，然后在情况1中再进行分类
		// //并且注意我们对输入的大小写不区分
			// case "U":
			// case "u":{
			// System.out.println("************ 买单功能 ************");
		    // System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		    // System.out.println("   "+"输入： S A D L Q 进入操作");
		    // System.out.println("******************************************");
            // System.out.println("***************** 商品清单 ******************");
			// System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			// for(int i=0;i<goods.length;i++){
			// System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			// }
			// System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			// System.out.println("*********************************************");
			// //再对第一种情况的5种情况进行分类
		// //用户输入字符
		// String inputCharu=scanner.nextLine();//表述输入一个字符串
			// switch(inputCharu){
				// case "S":
				// case "s":
				// case "A":
				// case "a":
				// case "D":
				// case "d":
				// case "L":
				// case "l":
				// case "Q":
				// case "q":{
					// System.out.println("************ 买单功能 ************");
                    // System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		            // System.out.println("   "+"输入： S A D L Q 进入操作");
		            // System.out.println("******************************************");

				// }
			// }
			// break;
			// }
		// //情况2：[S]设置——》在情况2中又分了5种情况，再对这5种情况进行分析
		    // case "S":
			// case "s":{
     		// System.out.println("************ 设置功能 ************");
			// System.out.println("   "+"[S] 查看"+" "+"[A] 上架"+" "+"[D] 下架"+" "+"[U] 修改"+"[Q] 退出");
		    // System.out.println("   "+"输入： S A D U Q 进入操作");
			// String inputChars=scanner.nextLine();//表述输入一个字符串
			// switch(inputChars){
				// case "S":
				// case "s":{
            // System.out.println("***************** 商品清单 ******************");
			// System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			// for(int i=0;i<goods.length;i++){
			// System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			// }
			// System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			// System.out.println("*********************************************");
				// }
				// case "A":
				// case "a":{
					// System.out.println("请输入上架商品信息（如下格式： 1 餐巾纸 1.4）：");
					// int inputnum=scanner.nextInt();//用户输入上架商品的单号
					// String inputname=scanner.nextLine();//用户输入的上架商品名称
					// state[inputnum]=inputname;
					// double inputprice=scanner.nextDouble();//用户输入上架商品价格
				    // price[inputnum]=inputprice;
					            // System.out.println("***************** 商品清单 ******************");
			                    // System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
			                    // for(int i=0;i<goods.length;i++){
			                    // System.out.println("         "+goods[i]+"          "+state[i]+"            "+price[i]);
			                // }
			                   // System.out.println("         "+goods[9]+"         "+state[9]+"            "+price[9]);
			                   // System.out.println("*********************************************");

				// }
			// }
		    // break;
		// }
		// //情况3：[A]关于
		// //不区分大小写
		    // case "A":
			// case "a":{
		    // System.out.println("***************   关于   ***************");
			// System.out.println("        "+"名称：简易收银台");
		    // System.out.println("        "+"功能：基于字符界面的收银台操作系统");
			// System.out.println("        "+"作者：secondriver");
			// System.out.println("        "+"版本:v0.0.1");
			// System.out.println("        "+"意见反馈：secondriver@yeah.net");
		    // System.out.println("******************************************");
		    // break;
		// }
		// //情况4：
		    // case "Q":
			// case "q":{
			// System.out.println("************ 欢迎使用，下次再见 ************");
			// break;
		// }
		// }

	// }
}










//动态开辟数组

		public static void main(String[] args){
		Goods1[] goods=new Goods1[10];
		//动态初始化
		for(int i=0;i<goods.length;i++){
			goods[i]=new Goods1(i,"未上架",0.0);
		}
	
		for(int i=0;i<goods.length;i++){
         print(goods);			
			}
	}





















