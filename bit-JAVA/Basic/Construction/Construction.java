// //1.普通代码块
// public class Construction{
	// public static void main(String[] args){
		// {
		// int num=10;
		// System.out.println(num);
		// }
		// int num=100;
		// System.out.println(num);
	// }
// }


// //2.构造块
// class Person{
	// {
	// //定义在类中不加任何的修饰符
	// System.out.println("这是Person的构造块");
	// }
	// public Person(){//注意某个类的构造方法一定要在这个类里.
		// System.out.println("这是Person的构造方法");
	// }
// }

	// public class Construction{
		// public static void main(String[] args){
			// new Person();//匿名对象：在创建某个类的一个对象的时候，就会调用它的构造方法，并且在调用构造方法之前要先执行构造块
			// new Person();//创建几次对象就执行几次构造块，构造块时和构造方法紧挨着的
		// }
	// }
	
	
	//3.静态代码块
	
	// //（1）在非主类的静态块
	 //class Person{
	 
	// //以后在写代码的时候就按照执行的顺序来写，这样的话也有助于记住这个顺序
    // //静态块——》构造块——》构造方法	
	 // //静态块
	  //static{
		  //System.out.println("这是Person的静态块");
	  //}
		 
	 // //构造块	 
	 // //定义在类中不加任何的修饰符
	  //{
	  //System.out.println("这是Person的构造块");
	  //}
	 
	 // //构造方法
	 // public Person(){//注意某个类的构造方法一定要在这个类里.
		  //System.out.println("这是Person的构造方法");
	  //}
	//}

	 // public class Construction{
		  //public static void main(String[] args){
			  //new Person();//匿名对象：在创建某个类的一个对象的时候，就会调用它的构造方法，并且在调用构造方法之前要先执行构造块
			  //new Person();//创建几次对象就执行几次构造块，构造块时和构造方法紧挨着的
		  //}
	  //}
	 

	// //（2）在主类中的静态代码块
	 public class Construction{
		
	// //以后在写代码的时候就按照执行的顺序来写，这样的话也有助于记住这个顺序
    // //静态块——》构造块——》构造方法	
	 // //静态块
	  static{
		  //System.out.println("这是Construction的静态块");
	  }
		 
	 // //构造块	 
	 // //定义在类中不加任何的修饰符
	  {
	  System.out.println("这是Construction的构造块");
	  }
	 
	 // //构造方法
	  public Construction(){//注意某个类的构造方法一定要在这个类里.
		  System.out.println("这是Construction的构造方法");
	  }
		  public static void main(String[] args){
			 // //new Construction();//匿名对象：在创建某个类的一个对象的时候，就会调用它的构造方法，并且在调用构造方法之前要先执行构造块
			 // //new Construction();//创建几次对象就执行几次构造块，构造块时和构造方法紧挨着的
			 System.out.println("这是main方法");
	   }
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	