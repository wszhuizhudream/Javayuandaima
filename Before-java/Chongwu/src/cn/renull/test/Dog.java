package cn.renull.test;

public class Dog {
   private String name="Íú²Æ";
   public int age=-1000;
   private int love=0;
   
   
   
   

public String getName() {
	return name;
}
public void setName(String name) {
	if(name.length()>1 && name.length()<=4){
	    this.name = name;
	}
}



public int getAge() {
	return age;
}
public void setAge(int age) {
	if(age>0 && age<150){
		
		this.age = age;
	}else{
		this.age=0;
	}
}

   
   
   
//   public void play(int n){
//       int lovalv=5;
//       age=age-n;
//       System.out.println(name+"\t"+age+"\t"+love+"\t"+lovalv);
//   }
//   
//   public static void main(String[] args) {
//	   Dog d=new Dog();
//	   d.play(5);
//   }
}
