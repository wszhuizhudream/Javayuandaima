public class Computer{
	//顺序：属性——》构造方法——》封装
	
	//1.属性
	private String type;  //型号
	private String color;//颜色
	private int price;//价钱
    
	//2.构造方法
    public Computer(String type){
		this.type=type;
	}	
	public Computer(String type,String color){
		this(type);
		this.color=color;
	}
	public Computer(String type,String color,int price){
		this(type,color);//通过this方法调用含有两个参数的构造方法
		this.price=price;
	}
	
	//3.封装
	//getter
	String getType(){
		return type;
	}
	String getColor(){
		return color;
	}
	int getPrice(){
		return price;
	}
    //setter
	void setType(String type){
		this.type=type;
	}
	void setColor(String color){
		this.color=color;
	}
	void setPrice(int price){
		this.price=price;
	}
	
	//普通方法——》定义为公有的才可以让外界访问
	public String getComputerInfo(){
		return "这台电脑的类型是"+type+",它的颜色是"+color+",它的价格是"+price;
	}
	
	//一定要注意一个类的方法一定要是公有的，因为公有的才可以让外界访问
	public void computerQ(){
		System.out.println("这台电脑的性能比较好");
	}
	
}