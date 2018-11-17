 //1.
// class Outer1{
	// private String msg="外部类的属性";
	
	// //下面定义一个内部类
	// class Inner{
		// public void print(){//内部类的一个普通方法
			// System.out.println(msg);//直接调用外部类的属性
		// }
	// }
	
	// //在外部类中定义一个方法，该方法负责产生内部类对象并且调用内部类的print()方法
	// public void fun(){
		// Inner in=new Inner();//创建一个内部类的对象
		// in.print();//通过内部类的对象访问内部类的方法
	// }
// }

// public class TestOuter1{
	// public static void main(String[] args){
		// Outer1 out = new Outer1();//外部类对象
		// out.fun();//外部类方法
		
	// }
// }

 
 
 // //2.内部类实现多继承
 // class A{
	 // private String name = "A类的私有属性";
	 // public String getName(){
		 // return name;
	 // }
 // }
 
 // class B{
	 // private int age = 20;
	 // public int getAge(){
		// return age;
	 // }
 // }
 
 // class Outer{
	 // //定义一个内部类继承类A
	 // private class InnerClassA extends A{
		// public String name(){
			// return super.getName(); 
		// }
	 // }
	 // //定义一个内部类继承类B
	 // private class InnerClassB extends B{
		 // public int age(){
			// return super.getAge();
		 // }
	 // }
	
	// public String name(){
		// return new InnerClassA().name();
	// }
	// public int age(){
		// return new InnerClassB().age();
	// }
 // }
 
 // public class TestOuter1{
	 // public static void main(String[] args){
		// Outer out = new Outer();
		// System.out.println(out.name());
		// System.out.println(out.age());
	 // }
 // }
 
 
 // //3.内部类可以直接访问外部类的元素
 // class Outer{
	 // private String outName;
	 // private int outAge;
	 // class Inner{
		 // private int innerAge;
		 // public Inner(){
			 // Outer.this.outName="i am outer class";
			 // Outer.this.outAge=2;
		 // }
		 // public void display(){
			 // System.out.println(outName);
			 // System.out.println(outAge);
		 // }
	 // }
 // }
	 // public class TestOuter1{
		 // public static void main(String[] args){
			 // Outer.Inner inner = new Outer().new Inner();
			 // inner.display();
		 // }
	 // }
 
 // // //4.外部类通过内部类的对象来访问内部类
 // //注意：不在同一个类中也是可以定义其他类的对象的。
  // class Outer{
	 
	  // class Inner{
		  // private String msg2;
		  // public String getMsg2(){
			  // return msg2;
		  // }
		  // public void setMsg2(String msg2){
			  // this.msg2=msg2;
		  // }
		  // public void print(){
			  // System.out.println("这是内部类的方法");
		  // }
		 
		 
	  // }
	 
	 // // //外部类的一个公有方法调用内部类的私有属性以及方法
	  // public void fun(){
		  // Inner inner = new Inner();//在外部类中创建内部类的对象
		  // inner.print();//通过内部类的对象访问内部类的方法
		  // inner.setMsg2("内部类属性");//通过内部类对象访问内部类的属性
		  // System.out.println(inner.getMsg2());
	  // }
	 
  // }
  
  // public class TestOuter1{
	  // public static void main(String[] args){
		  // Outer outter= new Outer();
		  // outter.fun();
	  // }
  // }
  

// //内部类的分类：
// //1.成员内部类
// class Outer{
	// class Inner{
		
	// }
// }  
 
// //3.使用方法内部类
// class Outer {
	// private int num;
	// public void display(int test){
		// class Inner{
			// private void fun(){
				// num++;//默认值0+1=1
				// System.out.println(num);
				// System.out.println(test);
			// }
		// }
		// new Inner().fun();//这条语句只有在这个方法中才有效，出了这个方法就无效了。这个就是方法内部类
	// }
// }
// public class TestOuter1{
	// public static void main(String[] args){
		// Outer out = new Outer();
		// out.display(20);
	// }
// }
 

//4.如何使用匿名内部类
 interface MyInterface{
	 void test();
 }
 class Outer{
	 private int num;
	 public void display(int para){
		 //匿名内部类，实现了MyInterface接口
		 new MyInterface(){
			//方法重写
			public void test(){
				System.out.println("匿名内部类"+para);
			}
		 }.test();
	 }
 }
 public class Test {
 public static void main(String[] args){
	 Outer Outer = new Outer();
	 outer.display(20);
 }
 }
 
 
 
 
 
 
 
 
 
 
 