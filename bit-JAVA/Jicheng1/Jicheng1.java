// class Person{
	// private String name;
	// private int age;
	
	// public String getName(){
		// return name;
	// }
	
	// public void setName(String name){
		// this.name=name;
	// }
	
	// public int getAge(){
		// return age;
	// }
	
	// public void setAge(int age){
		// this.age=age;
	// }
// }
// class Student{
	// private String name;
	// private int age;
	// private school;
	
	// public String getName(){
		// return name;
	// }
	
	// public void setName(String name){
		// this.name=name;
	// }
	
	// public int getAge(){
		// return age;
	// }
	
	// public void setAge(int age){
		// this.age=age;
	// }

	// public String getSchool(){
		// return school;
	// }
	
	// public void setSchool(String school){
		// this.school=school;
	// }
// }




// class Person{
	// private String name;
	// private int age;
	
	// public String getName(){
		// return name;
	// }
	
	// public void setName(String name){
		// this.name=name;
	// }
	
	// public int getAge(){
		// return age;
	// }
	
	// public void setAge(int age){
		// this.age=age;
	// }
// }
// class Student extends Person{//定义一个子类并且继承Person类,并且扩充其功能
// private String school;
	 // public String getSchool(){
		 // return school;
	 // }
	
	 // public void setSchool(String school){
		 // this.school=school;
	 // }

// }
// public class Jicheng1{
	// public static void main(String[] args){
		// Student t1=new Student();
		// t1.setName("stenve");
		// t1.setAge(16);
		// t1.setSchool("三");//私有属性不可以通过t1.school来访问
		// System.out.println("姓名"+t1.getName()+"年龄"+t1.getAge()+"学校"+t1.getSchool());//继承完以后原来的这两个属性都是私有的，所以我们需要通过它
		                                                           // //的方法来访问这两个属性。
	// }
// }



// class Person{
	// private String name;
	// private int age;
	// public Person(){
		// System.out.println("这是父类的无参构造");
	// }
	
	// public String getName(){
		// return name;
	// }
	
	// public void setName(String name){
		// this.name=name;
	// }
	
	// public int getAge(){
		// return age;
	// }
	
	// public void setAge(int age){
		// this.age=age;
	// }
// }
// class Student extends Person{//定义一个子类并且继承Person类,并且扩充其功能
// private String school;
// public Student(){
	// super();
	// System.out.println("这是子类的无参构造");
// }
	 // public String getSchool(){
		 // return school;
	 // }
	
	 // public void setSchool(String school){
		 // this.school=school;
	 // }

// }
// public class Jicheng1{
	// public static void main(String[] args){
		// Student t1=new Student();
		// t1.setName("stenve");
		// t1.setAge(16);
		// t1.setSchool("三");//私有属性不可以通过t1.school来访问
		// System.out.println("姓名"+t1.getName()+"年龄"+t1.getAge()+"学校"+t1.getSchool());//继承完以后原来的这两个属性都是私有的，所以我们需要通过它
		                                                           // //的方法来访问这两个属性。
	// }
// }



class Person{
	private String name;
	private int age;
	public Person(String name) {
		this.name=name;
		System.out.println("这是父类的含有一个参数的构造");
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		System.out.println("这是父类的含有两个参数的构造函数");
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
}
class Student extends Person{//定义一个子类并且继承Person类,并且扩充其功能
private String school;
// public Student(String name,int age,String school){
	// //super(name,age);//指定调用的到底是父类的哪个构造函数
	// this.school=school;
	// System.out.println("这是子类的构造");
// }

public Student(String name,String school){
	//super(name,age);//指定调用的到底是父类的哪个构造函数
	super(name);
	this.school=school;
	System.out.println("这是子类的构造函数");
}

	 public String getSchool(){
		 return school;
	 }

}
public class Jicheng1{
	public static void main(String[] args){
		Student t1=new Student("stenve","三");
		//t1.setSchool("三");//私有属性不可以通过t1.school来访问
		System.out.println("姓名"+t1.getName()+"年龄"+t1.getAge()+"学校"+t1.getSchool());//继承完以后原来的这两个属性都是私有的，所以我们需要通过它
		                                                           //的方法来访问这两个属性。
	}
}



