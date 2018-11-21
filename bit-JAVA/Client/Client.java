//1.工厂设计模式（重点）
//没有模式的情况：
//一般是这样，对于一个共同有的行为就定义为一个接口中的抽象方法；对于含有这种方法的不同种类
//就定义为一个类，这个类去实现接口中的方法，这样就可以达到我们的效果。
// interface Clothes{
	// void printClothes();
// }
// class A implements Clothes{
	// public void printClothes(){
		// System.out.println("这是A款衣服");
	// }
// }
// class B implements Clothes{
	// public void printClothes(){
		// System.out.println("这是B款衣服");
	// }
// }
// public class Client{
	// public void buyClothes(Clothes clothes){
		// clothes.printClothes();//实现买衣服
	// }
	// public static void main(String[] args){
		// Client client=new Client();
		// client.buyClose(new A());//这样就表示创建了A款衣服的实例，但是我们必须得知道创建对象的过程
	// }
//那么问题来了；如果刘同学这时候又看上了另外一款衣服，我们就不得不返回客户端进行修改了。所以下面我们采用简单工厂模式进行实现。

//1.简单工厂模式：专门定义一个类，用来创建其他类的实例，被创建的实例通常都具有共同的父类。
//买一件衣服的例子
// import java.util.Scanner;
// interface Clothes{
	// public void print();
// }
// class A implements Clothes{
	// public void print(){
		// System.out.println("这是A款衣服");
	// }
// }
// class B implements Clothes{
	// public void print(){
		// System.out.println("这是B款衣服");
	// }
// }
// //定义一个类来创建对象
// class ClothesFactory{//这个就是生产衣服的工厂，生产衣服由它实现，即是创建对象由它实现，
// //我们的客户不用知道我们衣服的对象怎么实例化。
	// public static Clothes getInstance(String type){
		// Clothes clothes=null;//初始化对象
		// if(type.equals("A")){//创建对象，开辟空间，返回具体的对象
			// return new A();
		// }else{
			// return new B();
		// }
	// }
// }

// public class Client {
	// public void buyClothes(Clothes clothes){
		// clothes.print();//可以起到创建对象的作用:最后对应的衣服去调用对应的print()
	// }
	// public static void main(String[] args){
		// Client client=new Client();
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("请输入您想要的衣服款式：");
		// String type=scanner.nextLine();
		// Clothes clothes=ClothesFactory.getInstance(type);//通过传入的类型判断是否是在所给范围内的类型
		// client.buyClothes(clothes);//这儿传入的clothes是创建好之后的对象，即是传入以后得到相应的那个款式的衣服
	// }
// }
//我们来实现一个买电脑的例子
//电脑的类型分为：HP、Lenvoe
//电脑的接口
// import java.util.Scanner;
// interface Computer{
	// public void print();//对于每一个类它的功能是不同的
// }
// //HP的电脑
// class HP implements Computer{
	// public void print(){
		// System.out.println("这是一台HP电脑");
	// }
// }
// //联想的电脑
// class Lenvoe implements Computer{
	// public void print(){
		// System.out.println("这是一台联想电脑");
	// }
// }
// //定义一个生产电脑的工厂：根据客户传入的类型专门用来创建对象
// class ComputerFactory{
	// //定义一个生产对象的方法
	// public static Computer printComputer(String type){ 
	// /*error	如果采用以下这种方法就会出现错误，因为这样就没有了返回语句，所以我们需要用它下面的这种方法
	// if(type.equals("HP")){
		// return new HP();
	// }else if(type.equals("Lenvoe")){
		// return new Lenvoe();
	// }	
	// */
	// Computer computer=null;//初始化了一个对象
	// if(type.equals("HP")){
		// computer=new HP();
	// }else if(type.equals("Lenvoe")){
		// computer=new Lenvoe();
	// }
	// return computer;//这样函数才有返回值
// }
// }
// public class Client{
	// public void buyComputer(Computer computer){
		// computer.print();
	// }
	// public static void main(String[] args){
		// Client client = new Client();
		// Scanner scanner=new Scanner(System.in);
		// System.out.println("请输入你想要的类型：");
		// String type=scanner.nextLine();
		// Computer computer = ComputerFactory.printComputer(type);//静态方法通过类名调用
		// client.buyComputer(computer);
	// }
// }



//工厂方法模式
interface Computer{
	void printCOmputer();
}
class HP implements Computer{
	public void printCOmputer(){
		System.out.println("这是HP电脑");
	}
}
class Lenvoe implements Computer(){
	public void printCOmputer(){
		System.out.println("这是联想电脑");
	}
}
//定义一个接口的工厂
interface ComputerFactory{
	Computer createComputer();
}
//创建工厂类去实现接口的方法
//属于HP的工厂类
class Ms1Factory implements ComputerFactory{
	public Computer createComputer(){
		return new HP();
	}
}
//属于Lenvoe的工厂类
class Ms2Factory implements ComputerFactory{
	public Computer createComputer(){
		return new Lenvoe();
	}	
}
//不同的工厂类创建自己的对象
public class Client{
	public void buyComputer(Computer computer){
		computer.printComputer();
	} 
	public static void main(String[] args){
		Client client=new Client();
		ComputerFactory factory=new Ms2Factory();//实现向上转型——》父类接口
		client.buyComputer(factory.createComputer());
	}
}



































