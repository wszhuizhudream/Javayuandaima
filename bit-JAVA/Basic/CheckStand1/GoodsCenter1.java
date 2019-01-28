import java.util.Scanner;
//购物中心就是具体实现交互的过程，将每一个功能都抽象为方法
public class GoodsCenter1{
			//需要开辟一个对象数组：总共有十个产品
		public static Goods1[] goods=new Goods1[]{//动态初始化（不可以指定长度）
		for(int i=0;i<goods.length;i++){
			goods[i]=(i+1,"--[未上架]",0.0);
		}
		}
		
//1.进入主页面
	public void use(){
		System.out.println("************欢迎使用简易收银台************");
		System.out.println("      [U] 使用       [S] 设置       [A] 关于       [Q] 退出");
		System.out.println("      输入： U S A Q 进入操作");
		System.out.println("******************************************");
	 	Scanner scanner=new Scanner(System.in);
		//用户输入字符
		String inputChar=scanner.nextLine();//表示输入一个字符
		//对于输入的字符一共要做4种情况的判断下面对于这4种情况分别进行相应的处理	
		//情况1：[U]使用——》在情况1种还会出现5种情况，然后在情况1中再进行分类
		//并且注意我们对输入的大小写不区分
		if(inputChar.equals("U")||inputChar.equals("u")){
			payBill();
}
		//情况2：[S]设置——》在情况2中又分了5种情况，再对这5种情况进行分析
		if(inputChar.equals("S")||inputChar.equals("s")){
			setFuction();
}
		//情况3：[A]关于
		//不区分大小写
		if(inputChar.equals("A")||inputChar.equals("a")){
			aboutState();
		}
		//情况4：
		if(inputChar.equals("Q")||inputChar.equals("q")){
				exitUse();
		}
		}
		
//2.买单功能
	public void payBill(){
			System.out.println("************ 买单功能 ************");
		    System.out.println("      [S] 查看       [A] 下单       [D] 取消       [L] 浏览   [Q] 退出");
		    System.out.println("      输入： S A D L Q 进入操作");
		    System.out.println("******************************************");
		    Scanner scanner=new Scanner(System.in);
		    String inputCharu=scanner.nextLine();//表述输入一个字符
		    if(inputCharu.equals("S")||inputCharu.equals("s")){
			printOrder();
			payBill();
			
		}
		    if(inputCharu.equals("A")||inputCharu.equals("a")){
				        placeAnOrder();
			            payBill();
		}
		    if(inputCharu.equals("D")||inputCharu.equals("d")){
			            payBill();
		}
		    if(inputCharu.equals("L")||inputCharu.equals("l")){
			            payBill();
		}
		    if(inputCharu.equals("Q")||inputCharu.equals("q")){
			            System.out.println("退出使用功能");
			            use();
		}
			
}
//3.使用里面的下单功能
public void placeAnOrder(){
	System.out.println("请输入需要购买的商品编号以及数量（格式如：1 2）");
	Scanner scanner=new Scanner(System.in);
    int inputNumP=scanner.nextInt();
	int inputCount=scanner.nextInt();
	int tmp=inputNumP-1;
    double  unitPrice=goods[tmp].getGoodsPrice();
	double totalPrice=unitPrice*inputCount;
	System.out.println("购买商品总价为："+totalPrice);
}
//4.设置功能
public void setFuction(){
	     	System.out.println("************ 设置功能 ************");
			System.out.println("      [S] 查看       [A] 上架       [D] 下架       [U] 修改   [Q] 退出");
		    System.out.println("      输入： S A D U Q 进入操作");
			System.out.println("******************************************");
		Scanner scanner=new Scanner(System.in);
		String inputChars=scanner.nextLine();//表述输入一个字符串
		//查看
		if(inputChars.equals("S")||inputChars.equals("s")){	
			printOrder();
		}
		//上架
		if(inputChars.equals("A")||inputChars.equals("a")){
					putaway();
					setFuction();
	
		}
		//下架
		if(inputChars.equals("D")||inputChars.equals("d")){
					soldout();
					int inputNumX=scanner.nextInt();//用户输入下架商品的单号
					afterSoldoutPrint(inputNumX);
					setFuction();
	
		}
		//修改
		if(inputChars.equals("U")||inputChars.equals("u")){
			        modification(); 
					setFuction();
		}
		//退出
		if(inputChars.equals("Q")||inputChars.equals("q")){
			        use();
		   }	

			
}


//5.商品上架并打印上架以后的清单
public void putaway(){
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）");
	Scanner scanner=new Scanner(System.in);
	int inputNumS=scanner.nextInt();//用户输入上架商品的单号->3
	String inputNameS=scanner.next();//用户输入的上架商品名称->毛巾
	double inputPriceS=scanner.nextDouble();//用户输入上架商品价格->2.3
	//商品上架的之前需要判断这个商品的序号是否已经有了
	int tmp=inputNumS-1;
	String tmpName="--[未上架]";
	if(tmpName.equals(inputNameS)){
System.out.println("请选择上架的商品编号，当前修改商品未设置");	
	}else{
	goods[tmp].setGoodsNum(inputNumS);
	goods[tmp].setGoodsName(inputNameS);
	goods[tmp].setGoodsPrice(inputPriceS);
	System.out.println("***************** 商品清单 ******************");
	System.out.println("            编号            产品名称                  单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
	}
}


//6.查看功能：就是打印最新的商品清单

//7.下架功能
public void soldout(){
	System.out.println("请输入下架商品信息编号（如下格式：1）：");
}
//8.下架后打印商品清单（这个也是配套的工作，一旦用户输入下架的商品就应该打印）
public void afterSoldoutPrint(int goodsNum){
	//将用户输入的号码赋值给对象数组中相应的编号，将商品信息都恢复至初始化
	int tmp=goodsNum-1;
	goods[tmp].setGoodsNum(goodsNum);
	goods[tmp].setGoodsName("--[未上架]");
	goods[tmp].setGoodsPrice(0.0);
	System.out.println("***************** 商品清单 ******************");
	System.out.println("            编号            产品名称                  单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
}

//9.修改商品信息并打印修改以后商品的信息
public void modification(){
    	System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）");
	Scanner scanner=new Scanner(System.in);
	int inputNumG=scanner.nextInt();//用户输入修改商品的单号
	String inputNameG=scanner.next();//用户输入的修改商品名称-->为什么同时输入几个的时候必须要使用next才可以输入，不然最多只能输入两个？（next：是输入字符串；而nextLine：是输入单个字符）
	double inputPriceG=scanner.nextDouble();//用户输入修改商品价格
	int tmp=inputNumG-1;
	//判断当前商品是否已经上架，如果未上架则给出提示
	String tmpName=goods[tmp].getGoodsName();
	if(tmpName.equals(inputNameG)){
	goods[tmp].setGoodsNum(inputNumG);
	goods[tmp].setGoodsName(inputNameG);
	goods[tmp].setGoodsPrice(inputPriceG);
	System.out.println("***************** 商品清单 ******************");
	System.out.println("            编号            产品名称                  单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
	
	}else{
		System.out.println("请选择上架的商品编号，当前修改商品未设置");
	}

}

//10.退出设置功能
//打印主页面

//11.关于界面
public void aboutState(){
			System.out.println("***************   关于   ***************");
			System.out.println("           名称：简易收银台");
		    System.out.println("           功能：基于字符界面的收银台操作系统");
			System.out.println("           作者：ws                          ");
			System.out.println("           版本:v0.0.1");
			System.out.println("           意见反馈：secondriver@yeah.net");
		    System.out.println("******************************************");
            use();
}

//12.退出整个使用
public void exitUse(){
	System.out.println("******************************************");
	System.out.println("欢迎使用，下次再见");
	System.out.println("******************************************");
}


//13.打印商品清单
public void printOrder(){
	System.out.println("***************** 商品清单 ******************");
	System.out.println("            编号            产品名称                 单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");		
}
}










