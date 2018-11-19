// class Person{
	// private String name;
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		
		// new Student().print();//创建的是子类的对象
		// //通过调用以后我们可以发现，方法经过覆写以后，创建了子类的对象，虽然子类继承了父类的所有属性结构，但是经过覆写的方法相当于
		// //覆盖，在子类中只有覆写以后的方法；
	    // new Person().print();
		// //但是对于我们的父类来说，它的方法依然是自己的那个方法，执行的结果任然是自己的方法。
	// }
// }


// //错误的案例
// class Person{
	// public void print(){
		// System.ou.println("这是父类的方法");
	// }
// }
// class Student{
	 // void print(){//没有任何的修饰表示默认的限制权限
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		// new Student().print();
	// }
// }

// //super关键字
// class Person{
	 // int num=10;
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println(super.num);
		// super.print();//通过super调用父类的方法
		// System.out.println("这是子类经过覆写以后的方法");
	// }
// }
// public class Fuxie{
// public static void main(String[] args){
// new Student().print();	
// }
// }

//final修饰
// //1.final可以修饰类、修饰属性、修饰方法、修饰变量、修饰参数
// final class Person{}
// final private String name="张三";
// final public void print(){
	// System.out.println("这是被final修饰过的方法");
// }
//2.final修饰的类不可以继承
// final class Person{
	// public void print(){
		// System.out.println("这是被final修饰的类");
	// }
// }
// class Student extends Person{
	// public void print2(){
		// System.out.println("这是子类的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		// new Student().print2();
	// }
// }


// （3）被final修饰的方法不能被覆写；
 // class Person{
	// final public void print(){
		// System.out.println("这是被final修饰的类");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		// new Student().print2();
	// }
// }

// （4）被final修饰的属性需要在构造方法中初始化或者在定义的时候直接初始化；
// （5）被final修饰的属性、方法、变量一旦被初始化后就不能被再赋值了，并且它的类型也不会改变；
// public class Fuxie{
	// public static void main(String[] args){
		// final int num=3;
		// num=4;
	// }
// }
// （6）final定义常量；
// （7）对于static、final修饰的常量我们的命名规则是：大写字母，单词之间用下划线连接。

//多态
// //（1）向上转型
// class Person{
	// private String name;
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
	// public void Print2(){
		// System.out.println("这是被父类的第二个方法，子类不对它进行覆写");
	// }
// }
// class Student extends Person{
    // public void print(){
		// System.out.print("这是子类经过覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
	// Person per=new Student();//向上转型
	// per.print();//观察向上转型以后父类调用的方法到底是经过覆写以后的方法还是原来的方法
// //在这个程序里面，类型是Person类的，但是它对应开辟的空间是Student的，所以最后在父类对象调用方法的时候，调用的是被覆写过以后的方法
	// //对一个子类没有覆写的方法用父类的对象调用，看它是否会有结果输出。
	// per.print2();
	// }
// }
// //（2）向下转型
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
	// public void print2(){
		// System.out.println("这是父类的第二个方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
	// Student stu=new Person();//向下转型：将小类型转化为大类型
	// stu.print();
	// }
// }

// //(3)强转
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
	// public void print2(){
		// System.out.println("这是父类的第二个方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
	// Student stu=(Student)new Person();//向下转型：将小类型转化为大类型——》强转
	// stu.print();
	// }
// }
//(4)容易让人误解的转型
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
	// public void print2(){
		// System.out.println("这是父类的第二个方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
	// Person per = new Student();//向上转型
    // Student stu=per;
	// }
// }

//举一个基本数据类型看看
// public class Fuxie{
	// public static void main(String[] args){
		// //第一种方法：将一个整数直接赋给byte变量
		// byte b=20;
		// System.out.println(b);
		// //第二种方法：将一个整数先赋给int型变量，再利用这个变量给byte型变量赋值
		// int a=10;
		// byte b=a;
		// System.out.println(a);
	// }
// }

// //经过强转
// public class Fuxie{
	// public static void main(String[] args){
		// //第一种方法：将一个整数直接赋给byte变量
		// byte b=20;
		// System.out.println(b);
		// //第二种方法：将一个整数先赋给int型变量，再利用这个变量给byte型变量赋值
		// int a=10;
		// byte c=(byte)a;
		// System.out.println(c);
	// }
// }

//观察instanceof操作
// class Person{
	// public void print(){
		// System.out.println("这是父类的方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("这是子类经过覆写以后的方法");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		// Person per=new Student();//实现了向上转型
		// System.out.println(per instanceof Person);//判断是真还是假
		// System.out.println(per instanceof Student);
		// if(per instanceof Student){//避免ClassCastException
			// Student stu=(Student)per;//实现向下转型，因为在向下转型之前已经有了向上转型，所以
			                   // //经过了向上转型，所以才可以成功。
		// stu.print();//最后经过调用的方法是经过子类覆写以后的方法
		// }
	// }
// }


// //向上转型的应用
// class Person{
	// public void print(){
		// System.out.println("我是人类");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("我是学生");
	// }
// }
// class Worker extends Person{
	// public void print(){
		// System.out.println("我是工人");
	// }
// }
// public class Fuxie{
	// public static void main(String[] args){
		// whoyu(new Student());
		// whoyu(new Worker());
	// }
	// public static void whoyu(Person per){//传参：Person per=new Student();实现向上转型
		// per.print();
	// }
// }




