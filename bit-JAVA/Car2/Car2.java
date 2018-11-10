    public class Car2{
	//属性
	private String color;  //颜色
	private int id;     //车牌号
	private int price;  //价格
	
	//构造方法重载
	public Car2(String color){
		this.color=color;
	}
	public Car2(String color,int id){
		//因为已经存在含有一个参数的构造函数，所以可以通过this函数进行传递
		//但是需要注意，这个this只能写在一个函数的起始位置
		this(color);
		this.id=id;
	}
	public Car2(String color,int id,int price){
		this(color,id);
		this.price=price;
	}
	//Car类的方法--》行为
	//注意：在类里面的方法不应该定义为私有的，因为如果方法定义为私有的就没有办法访问了
	//那定义这个方法的意义就没有了。但是属性不一样。属性可以定义为私有的，私有的属性可以通过
	//公有的方法进行访问。
	  public static void khapTronPai(){//定义为静态方法
		System.out.println("向前开");
	}
	String carInfo(){
		return "这个车的颜色是："+color+"车牌号为："+id+"价格是:"+price;
	}
	
	//封装
	//用getter对属性进行封装，得到某个类的私有属性；get是得到，那么就有返回值
	//get函数是返回值，那么只需要函数没有参数
	String  getcolor(){
		return color;
	}
	int getid(){
		return id;
	}
	int price(){
		return price;
	}
	//set函数是为了给相应的属性传值，对创建对象时已经赋值的属性进行修改
	//那么它不需要返回值但需要参数进行传递
	//因为时在当前类里面的所以就算是私有属性也可以通过this进行访问。
	void setcolor(String color){
		this.color=color;
	}
	void setid(int id){
		this.id=id;
	}
	void setprice(int price){
		this.price=price;
	}
	public static void main(String[] agrs){
		Car2.khapTronPai();//静态方法直接通过类名访问，不需要创建对象
		Car2 car1=new Car2("红色",104789,100000);//此时创建了一个对象
		System.out.println(car1.carInfo());
	}
}
    
