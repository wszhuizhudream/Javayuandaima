//购物中心就是具体实现交互的过程，将每一个功能都抽象为方法
public class GoodsCenter1{
			//需要开辟一个对象数组：总共有十个产品
		public static Goods1[] goods=new Goods1[]{//静态初始化（不可以指定长度）
			new Goods1(1,"--[未上架]",0.0),
			new Goods1(2,"--[未上架]",0.0),
			new Goods1(3,"--[未上架]",0.0),
			new Goods1(4,"--[未上架]",0.0),
			new Goods1(5,"--[未上架]",0.0),
			new Goods1(6,"--[未上架]",0.0),
			new Goods1(7,"--[未上架]",0.0),
			new Goods1(8,"--[未上架]",0.0),
			new Goods1(9,"--[未上架]",0.0),
			new Goods1(10,"--[未上架]",0.0)
		};

//打印商品清单
public void printOrder(){
	System.out.println("***************** 商品清单 ******************");
	System.out.println("         "+"编号"+"      "+"产品名称"+"           "+"单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
}
		
//1.进入主页面
	public void Use(){
		System.out.println("************欢迎使用简易收银台************");
		System.out.println("   "+"[U] 使用"+" "+"[S] 设置"+" "+"[A] 关于"+" "+"[Q] 退出");
		System.out.println("   "+"输入： U S A Q 进入操作");
		System.out.println("******************************************");
	}
//2.买单功能
	public void PayBill(){
			System.out.println("************ 买单功能 ************");
		    System.out.println("   "+"[S] 查看"+" "+"[A] 下单"+" "+"[D] 取消"+" "+"[L] 浏览"+"[Q] 退出");
		    System.out.println("   "+"输入： S A D L Q 进入操作");
		    System.out.println("******************************************");	
}
//3.设置功能
public void SetFuction(){
	     	System.out.println("************ 设置功能 ************");
			System.out.println("   "+"[S] 查看"+" "+"[A] 上架"+" "+"[D] 下架"+" "+"[U] 修改"+"[Q] 退出");
		    System.out.println("   "+"输入： S A D U Q 进入操作");
			System.out.println("******************************************");
}
//4.商品上架
public void putaway(){
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）");
}
//5.上架后打印商品清单(这个是配套的工作)
public void afterPutawayPrint(int goodsNum,String goodsName,double goodsPrice){
	//弄清楚编号与数组里面这个数的下标的关系
	int tmp=goodsNum-1;
	//将输入的信息传递给数组对象中相应的对象
	goods[tmp].setGoodsNum(goodsNum);
	goods[tmp].setGoodsName(goodsName);
	goods[tmp].setGoodsPrice(goodsPrice);
	System.out.println("***************** 商品清单 ******************");
	System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
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
	System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
}
//9.修改商品信息
public void modification(){
	System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）");
}
//10.修改商品信息后打印商品清单
public void afterModificationPrint(int goodsNum,String goodsName,double goodsPrice){
	int tmp=goodsNum-1;
	//判断当前商品是否已经上架，如果未上架则给出提示
	String tmpName=goods[tmp].getGoodsName();
	if(tmpName.equals(goodsName)){
	goods[tmp].setGoodsNum(goodsNum);
	goods[tmp].setGoodsName(goodsName);
	goods[tmp].setGoodsPrice(goodsPrice);
	System.out.println("***************** 商品清单 ******************");
	System.out.println("         "+"编号"+"      "+"产品名称"+"            "+"单价");
	for(int i=0;i<goods.length;i++){
		System.out.println("         "+goods[i].getGoodsNum()+"        "+goods[i].getGoodsName()+"           "+goods[i].getGoodsPrice());
	}
	System.out.println("******************************************");
	
	}else{
		System.out.println("请选择上架的商品编号，当前修改商品未设置");
	}
}
//11.退出设置功能
	//打印主页面

//12.关于界面
public void aboutState(){
			System.out.println("***************   关于   ***************");
			System.out.println("        "+"名称：简易收银台");
		    System.out.println("        "+"功能：基于字符界面的收银台操作系统");
			System.out.println("        "+"作者：secondriver");
			System.out.println("        "+"版本:v0.0.1");
			System.out.println("        "+"意见反馈：secondriver@yeah.net");
		    System.out.println("******************************************");

}
//13.退出整个使用
public void exitUse(){
	System.out.println("******************************************");
	System.out.println("欢迎使用，下次再见");
	System.out.println("******************************************");
}
}













