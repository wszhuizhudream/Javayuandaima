//javaSE面向对象编程——类于对象（下）
//4.覆写
//（1）方法的覆写:首先方法的覆写必须有继承的关系，在子类中进行覆写.在覆写的时候还要求子类中进行覆写的方法要比父
//类中的方法权限更不为严格:public>protected>default>private
//父类:public ——>子类：public ;父类：protacted——>子类:protected/public ;
//父类：default——>子类：default/protected/public ; 父类：private——>子类看不见父类的方法，不可以进行方法覆写
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
// }
// class Student extends Person{
	// public void print(){//方法名、参数类型、参数个数、返回值类型相同
		// System.out.println("这是子类经过覆写以后的方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// new Person().print();//创建父类的对象并且调用经过覆写以后的方法
	// //从运行结果我们可以看出来，虽然print方法经过覆写了，但是我们的父类调用这个方法的时候还是执行的它原来的内容
		// new Student().print();//创建子类并且调用经过覆写以后的方法
	// //从运行结果可以看出来，经过覆写以后子类的调用的这个方法就是覆写以覆写的方法
	// }
// }

//错误的案例：
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
// }
// class Student extends Person{
	 // void print(){//方法名、参数类型、参数个数、返回值类型相同(错误：用了比父类方法更为严格的访问控制权限)
	 // //会提示无法覆盖父类的方法
		// System.out.println("这是子类经过覆写以后的方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// new Person().print();//创建父类的对象并且调用经过覆写以后的方法
	// //从运行结果我们可以看出来，虽然print方法经过覆写了，但是我们的父类调用这个方法的时候还是执行的它原来的内容
		// new Student().print();//创建子类并且调用经过覆写以后的方法
	// //从运行结果可以看出来，经过覆写以后子类的调用的这个方法就是覆写以覆写的方法
	// }
// }
//总结：方法的覆写时，经过覆写以后，父类创建的对象调用的方法还是未经过覆写以后的方法，但是子类创建的对象调用的
//方法是经过覆写以后的方法。


//（2）属性的覆写:当子类定义的名称和父类名称完全相同的时候就叫属性覆写
// class Person{
	  // String name="张三";
	// public void print(){
		// System.out.println(name);
	// }
// }

// class Student extends Person{
	 // String name="李四";
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student();
		// System.out.println(stu.name);
	// }
// }


//（3）解释重载与覆写的区别
//方法重写：方法重写是方法名字相同，参数个数、参数类型、参数顺序不同；一般来说返回值的类型是一样的
//方法覆写：方法覆写是方法名字、参数个数、参数类型都相同，但是方法体不同即实现的函数功能不同叫做方法重写

//（4）super关键字
//super表示父类的意思，所以可以通过super调用父类的方法，分别是以下两种情况

//（4.1）super调用构造方法
//无参构造方法
// class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student();
	// }
// }

//有参构造方法
// class Person{
	 // private String name;
	// //当父类中没有了无参构造我们在子类里面就需要表明我们需要调用哪个构造方法
	// //如果父类在有多个构造方法，并且包含了无参构造我们也不可以不用指明调用哪个构造方法，系统会自动默认调用无参构造
	// //（1）无参构造
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// //（2）含有一个参数的构造
	// public Person(String name){
		// System.out.println("这是父类含有一个参数的构造");
		// this.name=name;
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(String name){
		// //(1)super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// //(2)调用父类的含有一个参数的构造
		// super(name);//name既可以是父类发私有属性也可以是父类的狗狗有属性，都可以访问成功；
		            // //重点在于我们需要知道在super的时候子类的构造方法也是需要含有这个参数的构造函数，在定义的时候就应该带上这个
					// //参数，不可以的是用super调用父类的含参构造方法的时候子类的构造方法为无参构造没有给这个super传参。
		// System.out.println("这是子类的构造方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student("张三");
	// }
// }


//（4.2）super调用普通方法
// class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
	// public void print(){
		// super.print();//通过super调用父类的普通方法
		// System.out.println("这是子类的普通方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student();
		// stu.print();
	// }
// }


//5.final关键字
//（1）使用final修饰一个类
//final修饰的类不可以继承

// //error
// final class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student();
	// }
// }

//（2）使用final修饰一个方法
//final修饰的方法不可以被覆写
// //error
// class Person{
	// final public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
	// }
	// public void print(){
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=new Student();
	// }
// }
//对类和方法总结：
//总结：为什么final修饰完类、方法以后不可以继承不可以覆写，原因在于final表示不可以更改的意思，而我们的继承和覆写都表示在原有
//的基础之上对它进行修改。所以是都不被允许的。

//（3）使用final定义常量
// public class Duotai{
	// public static final int LEVEL_A=100;//注意在final定义常量必须在类中定义，相当于它是类的属性，不是对象的属性
	// public static void main(String[] args){
		// System.out.println("LEVEL_A="+LEVEL_A);
	// }
// }

//（4）分析下面这个程序：
// byte b1=1,b2=2,b3,b6,b8;  
// final byte b4=4,b5=6,b7=9;   
// public void test() {       
// b3=(b1+b2);  /*语句1*/      
// b6=b4+b5;    /*语句2*/      
// b8=(b1+b4);  /*语句3*/      
// b7=(b2+b5);  /*语句4*/       
// System.out.println(b3+b6); 
// }
// public class Duotai{
	// byte b1=1,b2=2,b3,b6,b8;  
    // final byte b4=4,b5=6,b7=9;   
    // public void test() {       
    // b3=(byte)(b1+b2);  /*语句1*/  
// //b1 b2看起来像是byte型，但是在给b3赋值的时候它程序还没有执行，空间还没有分配，这时候只会根据修饰这个变量的类型来看判断这个变量
// //到底是什么类型。所以在进行b3=(b1+b2);这条语句的时候相当于是将int赋值给了byte，大类型转小类型程序自然不能通过。   
    // b6=b4+b5;    /*语句2*/ 
// //正确，因为final修饰的变量它的类型不会改变，就算还没有分配空间也会认为这个变量的类型是byte型
    // b8=(byte)(b1+b4);  /*语句3*/      
// //错误：b1不是byte类型
    // b7=(byte)(b2+b5);  /*语句4*/       
// //错误：b2不是byte类型
    // System.out.println(b3+b6); 
    // }

	// public static void main(String[] args){
		// Duotai t=new Duotai();
		// t.test();
	// }
		
// }
//6.多态
//（1）向上转型
// class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
	// public void print(){//方法覆写
		// System.out.println("这是子类的普通方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// // Person per=new Person();//没有向上转型，虽然有方法覆写，但是父类调用该方法的时候还是父类自己的方法
		// // per.print();
		// Person per=new Student();//向上转型
		// per.print();
	// }
// }



//（2）向下转型

// class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
	// public void print(){//方法覆写
		// System.out.println("这是子类的普通方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		// Student stu=(Student)new Person();//向下转型
		// //向下转型是将大类型转换为小类型，需要强转；强转以后编译可以通过，在语法层面来讲没有错误但是运行时候会出错。
		// stu.print();
	// }
// }

//（3）通过instanceof实现转型
// class Person{
	// private String name;
	// public Person(){
		// System.out.println("这是父类的构造方法");
	// }
	// public void print(){
		// System.out.println("这是父类的普通方法");
	// }
// }
// class Student extends Person{
	// public Student(){
		// super();//调用父类的构造方法，这个是无参构造方法，如果不写也会隐含的默认调用
		// System.out.println("这是子类的构造方法");
	// }
	// public void print(){//方法覆写
		// System.out.println("这是子类的普通方法");
	// }
// }
// public class Duotai{
	// public static void main(String[] args){
		 // Person per=new Student();//先实现向上转型
		 //为什么下面两个语句都是true?
		 // System.out.println(per instanceof Person);//true
		 // System.out.println(per instanceof Student);//true
     // if(per instanceof Student){
		 // Student stu=(Student)per;//要实现向下转型必须先实现向上转型，所以我们的判断条件是是否有实现向上转型
		 // stu.print();
	 // }		
		// }
// }
