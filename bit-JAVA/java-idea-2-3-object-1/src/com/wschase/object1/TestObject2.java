package com.wschase.object1;

/**面向对象——this关键字
 * Author:WSChase
 * Created:2019/2/3
 */
//this调用本类方法:
    //(1)调用普通方法：this.方法名称（参数）
    //(2)调用构造方法：this（参数）

    class Person1{
        private String name;
        private int age;

        public Person1(){
            System.out.println("-----无参构造----");
        }

        public Person1(String name){
            this();
            this.name=name;
        }

        //2.
        public Person1(String name,int age){//判断一下这个地方是否有调用无参构造
            this(name);
            this.age=age;
        }

        //1.
//        public Person1(String name,int age){
//            this.name=name;
//            this.age=age;
//            this.print();//调用普通方法
//        }

        public String getPersonInfo1(){
            return "姓名："+name+"，年龄："+age;
        }

        public void print(){
            System.out.println("--------------");
        }
}


////1.this调用普通方法
//public class TestObject2 {
//    public static void main(String[] args) {
//        Person1 p2=new Person1("李白",20);
//        System.out.println(p2.getPersonInfo1());
//    }
//}


//2.this调用构造方法
public class TestObject2{
    public static void main(String[] args) {
        //只定义对象调用构造方法
        Person1 person1=new Person1("李四",21);
    }
}