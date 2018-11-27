//认识抽象类
// abstract class Person{
	// private String name;
	// public void print(){
		// System.out.print("这是抽象类的普通方法");
	// }
	// public abstract void getPersonInfo();//只有含函数的名字但是没有函数体——>抽象方法
// }
// public class Chouxiang{
	// public static void main(String[] args){
		// Person p1=new Person();//错误的，抽象方法不可以实例化
		// p1.print();
	// }
// }

//使用抽象类
//情况1
// abstract class Person{
	// private String name;
	// public String getName(){
		// return this.name;
	// }
	// public void setName(String name){
		// this.name=name;
	// }
	// //下面定义一个抽象方法，只有方法名没有方法体
	// public abstract void getPersonInfo();
// }
// //Student类继承Person类，是它的子类
// class Student extends Person{
	// //实现抽象类中的抽象方法
	// public void getPersonInfo(){
		// System.out.println("I am a student");
	// }
// }
// public class Chouxiang{
	// public static void main(String[] args){
		// Person p=new Student();//向上转型，体现了多态
		// p.getPersonInfo();
	// }
// }


// //情况2：
// abstract class Person{
	// private String name;
	// public String getName(){
		// return name;
	// }
	// public void setName(){
		// this.name=name;
	// }
	// //下面定义抽象方法
	// public abstract void getPersonInfo();
	
	// public static Person getInstance(){//取得A类的对象
		// class Student extends Person{//定义方法内部类
			// public void getPersonInfo(){//实现抽象类中的抽象方法
				// System.out.println("I am a student");
			// }
		// }
        // return new Student();//创建的一个子类的匿名对象		
	// }
// }
// public class Chouxiang{
	// public static void main(String[] args){
		// Person p=Person.getInstance();
		// p.getPersonInfo();//被子类覆写以后的方法
	// }
// }


// //在抽象方法中定义构造方法
// abstract class Person {
	// private String name;
	// public Person(){//定义构造方法
		// System.out.println("这是抽象父类的构造方法");
	// }
	// public String getName(){
		// return name;
	// }
	// public void setName(String name){
		// this.name=name;
	// }
	// public abstract void getPersonInfo();//定义的一个抽象方法
// }
// class Student extends Person{
	// public Student(){
		// super();//继承后在构造方法中首先要调用父类的构造方法，此时只有无参构造方法，可以不写系统默认调用
		// System.out.println("这是子类的构造方法");
	// }
	// public void getPersonInfo(){//实现抽象类的抽象方法
		// System.out.println("这是父类的抽象方法通过子类实现了");
	// }
// }

// public class Chouxiang{
	// public static void main(String[] args){
	// Person p=new Student();
	// p.getPersonInfo();//其实质开辟的空间是子类的，所以他们两个的输出结果是相同的
	// System.out.println("================");
	// Student t=new Student();
	// t.getPersonInfo();
	// }
// }


//一段特殊代码
abstract class A{
	public A(){//3.调用父类的无参构造
		this.print();//4.调用被子类覆写的方法
	}
	public abstract void print();
}
class B extends A{
	private int num = 100;
	public B(int num){//2.调用子类的构造方法
		super();//3.执行父类的无参构造
		this.num=num;//7.给子类对象中的属性进行赋值
	}
	public void print(){//5.此时子类对象还没有被实例化，对应的值还是默认值
		System.out.println(this.num);//6.输出默认值
	}
}
public class Chouxiang{
	public static void main(String[] args){
		new B(30).print();//1.实例化子类对象
	}
}










