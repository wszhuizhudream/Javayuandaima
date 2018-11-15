//1.类属性
//2.类方法
//3.调用静态的属性和方法建议加上 类名.属性名   类名.方法名



public class PersonJin{
	static String country="中国";//这是一个静态的属性，这个属性的存储不在堆内存。它已经不属于对象了，它属于类
	private String name;
	private int age;
	
public void getPerson(){
	//country属于类的属性，所以我们不可以用对象this来调用，需要通过它的类名类来调用.对于静态变量不需要实例化对象

	System.out.println("姓名"+this.name+",年龄"+this.age+",国家"+PersonJin.country);	
	PersonJin.country="美国";
}

//在静态方法中不可以访问非静态是属性、非静态方法
public static void print(){
	System.out.println("一个");
}

//main方法是程序的入口，因为它是静态的方法不受对象的限制	
	public static void main(String[] args){
		PersonJin p1=new PersonJin();
		PersonJin p2=new PersonJin();
		p1.getPerson();
		p2.getPerson();
	    print();//静态方法可以通过类名访问，也可以直接写函数名进行访问
	
	
    }
}