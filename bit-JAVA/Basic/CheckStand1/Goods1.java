//商品的属性
//将商品抽象为一个类，这个类里面是商品的属性

public class Goods1{
	//商品的三个属性
	private int goodsNum;//编号
	private String goodsName;//产品名称
	private double goodsPrice;//单价
	
	//封装
	public int getGoodsNum(){
		return goodsNum;
	}
	public void setGoodsNum(int goodsnNum){
		this.goodsNum=goodsNum;
	}
	public String getGoodsName(){
		return goodsName;
	}
	public void setGoodsName(String goodsName){
		this.goodsName=goodsName;
	}
	public double getGoodsPrice(){
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice){
		this.goodsPrice=goodsPrice;
	}
	
	//构造方法
	//无参构造
	public Goods1(){
		
	}
	//含参构造方法
	public Goods1(int goodsNum,String goodsName,double GoodsPrice){
		this.goodsNum=goodsNum;
		this.goodsName=goodsName;
		this.goodsPrice=goodsPrice;
	}
	
}