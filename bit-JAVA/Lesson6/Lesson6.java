//一、代码块（笔试、面试常考知识点）
//1.普通代码块：普通代码块就是定义在方法中的代码块
// public class Lesson6{
	// public static void main(String[] args){
		// {//定义在main方法中的代码块——》普通代码块：可以让同一个变量被两次定义
		// int num=1;
		// System.out.println("num="+num);
		// }
		// int num=3;
		// System.out.println("num="+num);
	// }
// }
//2.构造块：与普通代码块区别它是定义在类中的代码块
// public class Lesson6{
	// //构造块先于构造方法执行，这样将它写在前面是为了暗示执行的顺序;并且构造块就像构造方法一样每创建一个对象就会执行一次
	// {
		// System.out.println("这是构造块");
	// }
	// public Lesson6(){
		// System.out.println("这是构造方法");
	// }
// public static void main(String[] args){
	// new Lesson6();//匿名对象
	// new Lesson6();//匿名对象
// }
// }
//3.静态代码块：用static修饰的代码块就叫静态代码块
//（1）在主类中：在主类中表示表示这个类含有main方法，即使程序的入口类，即是和文件名一样的类，即是公有的那个类，即是编译和运行的时
//候那个类名。
// public class Lesson6{
	//静态块:静态块只能放在类中，不可以放在方法中，并且构造块不管你创建几个对象都只执行一次
	//静态块之所以只执行一次是因为静态块是在JVM寻找要执行的字节码文件（就是那个你进行编译的文件，它的文件名就是主类的文件名）的
	//过程中就已经加载到虚拟机了，它是属于类的，所以在执行字节码文件的时候就不会再执行静态块了，所以最后的运行结果是静态块在最最
	//前面并且只执行一次。
	// static{
		// System.out.println("这是静态块");
	// }
	// //构造块
	// {
		// System.out.println("这是构造块");
	// }
	// //构造方法
	// public Lesson6(){
		// System.out.println("这是构造方法");
	// }
	// public static void main(String[] args){
		// new Lesson6();
		// new Lesson6();
	// }
	
// }

//（2）在非主类中
//不管是在主类中还是在非主类中静态块的要求都是一样的，并且执行顺序都是一样的。
//情况1：
// class A{
	// static{
		// System.out.println("这是静态块");
	// }
	// {
		// System.out.println("这是构造块");
	// }
	// public A(){
		// System.out.println("这是构造方法");
	// }
// } 
// public class Lesson6{
	// public static void main(String[] args){
	// new A();//注意：main方法中执行的代码，创建的类一定是要和含有静态块的类是相关的，否则JVM将不会将静态块加载到JVM中，这样的话
	        // //静态块就不会执行；
	// new A();
	// }
// }

// //情况2：
// class A{
	// static{
		// System.out.println("这是静态块");
	// }
	// {
		// System.out.println("这是构造块");
	// }
	// public A(){
		// System.out.println("这是构造方法");
	// }
// } 
// public class Lesson6{
	// public static void main(String[] args){
	// System.out.println("这是非主类中的主类");//这条语句和含有静态块的类完全没有关系，所以不会将静态块加载到JVM所以不会执行
	// }
// }

//4.同步代码块（以后学）







//二、内部类
//1.成员内部类
//成员内部类就像普通的内部类，在它的里面可以以出现任何由static修饰的属性或者方法；
//情况1：
// public class Lesson6{
	// private String msg="这是外部类的私有属性";
	// class Inner{
		// public Inner(){
		// System.out.println("这是成员内部类");
		// System.out.println(msg);//内部类可以直接访问外部类的属性，其实质相当于Lesson6.this.msg
		// }
		// // public void fun(){
			// // Inner in = new Inner();
		// // }
	// }
	// public static void main(String[] args){
		// Lesson6.Inner inner=new Lesson6().new Inner();//非静态内部类对象的创建必须依赖于外部类对象的创建，必须得外部类创建完对象
		                                           // //以后非静态内部类才可以创建对象。而成员内部类属于非静态内部类所以它遵循非静态
												   // //内部类创建对象的规则。
	// }
// }

//情况2：
// public class Lesson6{
	// private String msg="这是外部类的私有属性";
	// class Inner{
		// public Inner(){//从输出结果可以看到构造方法先于普通方法执行
			// System.out.println("这是成员内部类的构造方法");
		// }
			// public void print(){
		// System.out.println("这是成员内部类");
		// System.out.println(msg);//内部类可以直接访问外部类的属性，其实质相当于Lesson6.this.msg
			// }
		// // public void fun(){
			// // Inner in = new Inner();
		// // }
	// }
	// public static void main(String[] args){
		//成员内部类的类名：外部类.内部类
		// Lesson6.Inner inner=new Lesson6().new Inner();//非静态内部类对象的创建必须依赖于外部类对象的创建，必须得外部类创建完对象
		                                           // //以后非静态内部类才可以创建对象。而成员内部类属于非静态内部类所以它遵循非
												   //静态内部类创建对象的规则。但如果是在内部类里面创建对象那么就像普通类创建对
												   //象一样
												  
		// inner.print();	//也可以通过方法调用来实现									   
	// }
// }

//2.静态内部类
//情况1：不可以访问外部类的非静态属性
// class Outter{
	// private String msg="这是外部类的私有属性";//在本类以外的其他类中私有属性需要访问，那么就需要封装通过公有的方法来进行访问
	// public String getMsg(){
		// return msg;
	// }
	// static class Inner{
		// public Inner(){//只要创建内部类的对象就会执行这个无参构造
			// System.out.println("这是静态内部类的构造方法");
		// }
		// public void print(){
			// //在静态内部类中不可以访问外部类的非静态属性和非静态方法
			// System.out.println("这是静态内部类");
			// //System.out.println(msg);//相当于是Outter.this.msg//error:不可以访问非静态属性
		// }
	// }
	// public void fun(){
		// //在外部类创建静态内部类对象,不依赖外部类创建的对象；
		// //静态内部类的类名是：外部类.内部类
		// Outter.Inner inner=new Outter.Inner();
		// inner.print();
	// }
// }
// public class Lesson6{
	// public static void main(String[] args){
		// //创建一个外部类的对象访问fun方法
		// Outter out = new Outter();
		// out.fun();
	// }
// }

//情况2：将外部类的属性改为静态类那么就可以在静态内部类中访问外部类的属性
// class Outter{
	// private static String msg="这是外部类的静态私有属性";//在本类以外的其他类中私有属性需要访问，那么就需要封装通过公有的方法来进行访问
	// public String getMsg(){
		// return msg;
	// }
	// static class Inner{
		// public Inner(){//只要创建内部类的对象就会执行这个无参构造
			// System.out.println("这是静态内部类的构造方法");
		// }
		// public void print(){
			// //在静态内部类中不可以访问外部类的非静态属性和非静态方法,现在将外部类的属性改为静态属性，那么内部类就可以访问了
			// System.out.println("这是静态内部类");
			// System.out.println(msg);//相当于是Outter.this.msg
		// }
	// }
	// public void fun(){
		// //在外部类创建静态内部类对象,不依赖外部类创建的对象；
		// //静态内部类的类名是：外部类.内部类
		// Outter.Inner inner=new Outter.Inner();
		// inner.print();
	// }
// }
// public class Lesson6{
	// public static void main(String[] args){
		// //创建一个外部类的对象访问fun方法
		// Outter out = new Outter();
		// out.fun();
	// }
// }

//3.方法内部类
//在方法中的内部类，它与成员内部类相似，唯一的区别就是它的作用范围仅仅在一个方法内
// class Outter{
	// private String msg="这是外部类的私有属性";
	// public void print(int num){
		// //这是外部类的一个方法，下面将内部类定义在这个方法当中，那么它就叫做方法内部类，也叫做局部内部类
		// class Inner{
			// public void fun(){
			// System.out.println("这是一个方法内部类");
			// System.out.println(msg);//在方法内部类里面可以直接访问外部类的私有属性
			// System.out.println(num);
			// }
		// }
		// Inner in=new Inner();
		// in.fun();//这个只能在这个方法以内，如果超出方法那么将无效
	// }
// }
// public class Lesson6{
	// public static void main(String[] args){
	// //创建一个外部类的对象
	// Outter out = new Outter();
	// out.print(10);//调用外部类中包含内部类的方法，将内部类也执行了
	// }
// }
//4.匿名内部类
//定义在方法中的没有名字的内部类
//用匿名内部类实现和方法内部类一样的功能
// interface MyInterfance{
	// void test();
// }
// class Outter{
	// private String msg="这是外部类的私有属性";
	// public void print(int num){
		// //下面创建一个匿名内部类，因为它实现了一个接口
		       // new MyInterfance(){//接口的实现
				// public void test(){//方法重写实现接口
				// System.out.println("这是一个匿名内部类");
				// System.out.println(msg);
				// System.out.println(num);
			// }
				
			// }.test();//直接调用内部类，因为它没有名字不可以创建对象，如果不直接引用，那么将不可以访问了
		// }
	// }
// public class Lesson6{
	// public static void main(String[] args){
		// Outter out = new Outter();
		// out.print(10);
	// }
// }




//三、继承
//1.继承的实现
// //情况1：父类的构造方法是无参构造
// class A{
	 // int num=10;//私有属性
	 // String msg="这是A类的私有属性";
	// public A(){//A的无参构造方法
		// System.out.println("这是A的无参构造方法");
	// }
	// public void print(){
		// System.out.print("这是A类的方法");
	// }
// }
// class B extends A{
	// public B(){//B的无参构造
	// super();//在执行子类的构造方法之前必须先调用执行父类的构造方法；对于父类无参的构造方法会默认的调用
	// System.out.println("这是子类的构造方法");
	// }
	// public void fun(){
		// System.out.println(num);//输出的是父类的属性//erro:私有属性，不可以直接访问
		// System.out.println(msg);//error
	// }
// }
// public class Lesson6{
// public static void main(String[] args){
	// B b=new B();
	// b.fun();
	// b.print();//调用父类的方法
	// //注意执行的顺序是：父类的构造方法先于子类的构造方法
// }
// }

//情况2：父类的构造方法全是含参构造并且有多个构造函数的时候，没有无参构造了
//注意：在子类的构造方法中除了无参构造会默认调用意外，含参构造都不会默认调用，必须得自己手动调用，如果不调用父类的构造函数，那么
//编译就通过不了；
// class A{
	 // int num;//私有属性
	 // String msg;
	// public A(int num){//A的一个参数的含参构造方法
		// System.out.println("这是A的一个参数的参构造方法");
		// this.num=num;
	// }
	// public A(int num,String msg){//A的两个参数的含参构造方法
		// System.out.println("这是A的两个参数的构造方法");
		// this.num=num;
		// this.msg=msg;
	// }
	// public void print(){
		// System.out.print("这是A类的方法");
	// }
// }
// class B extends A{
	// //error:因为B类是无参构造的话就不能将参数传到super中，这样的话是在没有调用构造方法之前就引用了父类属性会报错说：
	// //无法在调用超类构造器（父类构造器）之前引用它的属性
	// // public B(){//B的无参构造
	// // super(num,msg);//在执行子类的构造方法之前必须先调用执行父类的构造方法；由于没有无参构造所以需要指明调用的构造方法
	// // System.out.println("这是子类的构造方法");
	// // }
	
	// public B(int num,String msg){
	// super(num,msg);//在执行子类的构造方法之前必须先调用执行父类的构造方法；由于没有无参构造所以需要指明调用的构造方法
	 // System.out.println("这是子类的构造方法");	
	// }
	// public void fun(){
		// System.out.println(num);//输出的是父类的属性//erro:私有属性，不可以直接访问
		// System.out.println(msg);//error
	// }
// }
// public class Lesson6{
// public static void main(String[] args){
	// B b=new B(10,"这是A类的私有属性");
	// b.fun();
	// b.print();//调用父类的方法
	// //注意执行的顺序是：父类的构造方法先于子类的构造方法
// }
// }








//2.继承的限制
//对于私有属性或者是私有方法的限制
//子类将继承父类的所有结构，那么私有属性也会继承，继承的私有属性是有访问权限的，不可以直接访问，必须通过封装的方法去访问
// class A{
	 // private int num=10;//私有属性,需要用封装外部才可以访问
	 // private String msg="这是A类的私有属性";
	 // public int getNum(){
		 // return num;
	 // }
	 // public void setNum(int num){
		 // this.num=num;
	 // }
	 // public String getMsg(){
		 // return msg;
	 // }
	 // public void setMsg(String msg){
		 // this.msg=msg;
	 // }
	// public A(){//A的无参构造方法
		// System.out.println("这是A的无参构造方法");
	// }
	// public void print(){
		// System.out.print("这是A类的方法");
	// }
// }
// class B extends A{
	// public B(){//B的无参构造
	// super();//在执行子类的构造方法之前必须先调用执行父类的构造方法；对于父类无参的构造方法会默认的调用
	// System.out.println("这是子类的构造方法");
	// }
	// public void fun(){
		// //下面两个语句每创建一次A类的对象都要执行一次构造方法
		// System.out.println(new A().getNum());//输出的是父类的属性//erro:私有属性，不可以直接访问
		// System.out.println(new A().getMsg());//error
	// }
// }
// public class Lesson6{
// public static void main(String[] args){
	// B b=new B();
	// b.fun();
	// b.print();//调用父类的方法
	// //注意执行的顺序是：父类的构造方法先于子类的构造方法
// }
// }

// class Person{
	// private String name;
	// private int age;
	// public String getName(){
		// return name;
	// }
	// public int getAge(){
		// return age;
	// }
	// public void setName(String name){
		// this.name=name;
	// }
	// public void setAge(int age){
		// this.age=age;
	// }
// }

// class Student extends Person{
	// public void fun(){
		// System.out.println(getName());
	// }
// }
// public class Lesson6{
	// public static void main(String[] args){
		// Student stu = new Student();
		// stu.setName("sdjd");//继承的父类的方法
		// //两种方法输出名字
		// System.out.println(stu.getName());
		// stu.fun();
	// }
// }
