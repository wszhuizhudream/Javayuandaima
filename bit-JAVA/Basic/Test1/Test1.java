// class Person{
	// private String name;
	// private int age;
	
	// public Person(String name,int age){
		// this.name=name;
		// this.age=age;
		// print();//调用普通方法
	// }
	// public String getpersonInfo(){
		// return "姓名"+name+",年龄"+age;
	// }
	// public void print(){
		// System.out.println("****************");
	// } 
// }
// public class Test1{
	// public static void main(String[] args){
		// Person per=new Person("张三",20);
		// System.out.println(per.getpersonInfo());
	// }
// }


// class Person{
	// private String name;
	// private int age;
	// public Person(){
		// System.out.println("****产生一个新对象*****");
	// }
	// public Person(String name){
		// System.out.println("****产生一个新对象*****");
		// this.name=name;
	// }
	// public Person(String name,int age){
		// System.out.println("*****产生一个新对象*****");
		// this.name=name;
		// this.age=age;
	// }
	// public String getPersonInfo(){
		// return "姓名"+name+"，年龄"+age;
	// }
// }
// public class Test1{
	// public static void main(String[] args){
		// Person per1=new Person();
		// Person per2=new Person("张三");
		// Person per3=new Person("张三",20);
		// System.out.println(per1.getPersonInfo());
		// System.out.println(per2.getPersonInfo());
		// System.out.println(per3.getPersonInfo());
	// }
// }

// class Person{
	// private String name;
	// private int age;
	// public Person(){
		// System.out.println("****产生一个新对象*****");
	// }
	// public Person(String name){
		// System.out.println("****产生一个新对象*****");
		// this();//调用本类无参构造函数
		// this.name=name;
	// }
	// public Person(String name,int age){
		// System.out.println("*****产生一个新对象*****");
		// this(name);//调用本类中有一个参数的构造函数
		// this.age=age;
	// }
	// public String getPersonInfo(){
		// return "姓名"+name+"，年龄"+age;
	// }
// }
// public class Test1{
	// public static void main(String[] args){
		// Person per1=new Person();
		// Person per2=new Person("张三");
		// Person per3=new Person("张三",20);
		// System.out.println(per1.getPersonInfo());
		// System.out.println(per2.getPersonInfo());
		// System.out.println(per3.getPersonInfo());
	// }
// }


class Person{
	public void print(){
		System.out.println("[print]方法:"+this);//这个this表示谁待用它，就是哪个对象
	}
}
public class Test1{
	public static void main(String[] args){
		Person p1= new Person();
		System.out.println("[main]方法"+p1);//后面连接的是对象p1
		p1.print();//p1调用print()方法
		System.out.println("=========");
		Person p2 = new Person();
		System.out.println("[main]方法"+p2);
		p2.print();
	}
}