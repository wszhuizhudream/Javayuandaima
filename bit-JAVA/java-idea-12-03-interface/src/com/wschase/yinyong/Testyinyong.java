package com.wschase.yinyong;

/**方法引用:
 * y=f(g(z(args)))
 * ()->参数
 * f->{}即是执行语句
 *  y就相当于式return语句
 * Author:WSChase
 * Created:2018/12/3
 */
//注意：我们的方法引用是函数与对象接轨，但是又有个要求就是我们在使用方法引用的时候要求我们这个函数在面向对象中
//已经存在了，这个时候我们采用方法引用可以减少方法体的内容，这样的话就将函数与对象结合起来了。
//那么如果这个函数在我们面向对象里面没有，我们就需要采用Lambda表达式或者是匿名对象的方法去实现这个功能。
//方法引用的目的：覆用我们面向对象中已经实现的内容。
//    //1.引用静态方法
//    //String类的valueOf()方法:将基本数据类型转化为整型
//    @FunctionalInterface
//    interface IUtil<P,R>{
//        public R switchPara(P p);
//    }
//
//public class Testyinyong {
//        public static void main(String[] args) {
//这个地方相当于是将接口中的方法进行了重写的，只是实现的方法是方法引用。-》前提是这个方法在面向对象中已经存在的方法。
//            IUtil<Integer,String> iu=String :: valueOf;//方法引用：就是将调用静态方法这个过程起了个别名叫iu，并且限定了这个别名的类型
// String str=iu.switchPara(1000);//相当于调用了String.valueOf(1000)
//            System.out.println(str.length());
//        }
//}

////2.引用对象方法
//@FunctionalInterface
//interface IUtil<R>{
//    public R switchPara();
//}
//public class TestDemo{
//    public static void main(String[] args) {
//        IUtil<String> iu="hello"::toUpperCase;//进行方法引用
//        System.out.println(iu.switchPara());
//    }
//}

////3.引用类中普通方法
////String有一个compareTo方法，次方法为普通方法
//@FunctionalInterface
//interface IUtil<R,P>{
//    public R compare(P p1,P p2);
//}
//public class Testyinyong{
//    public static void main(String[] args) {
//        IUtil<Integer,String> iu=String::compareTo;
//        System.out.println(iu.compare("刘","霍"));
//    }
//}

////4.引用构造方法
//class Person{
//    private String name;
//    private int age;
//    public Person(String name,int age){
//        super();
//        this.name=name;
//        this.age=age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [name="+name+"age="+age+"]";
//    }
//}
//@FunctionalInterface
//interface IUtil<R,PN,PA>{//这个括号里面的内容是方法返回类型和参数类型
//    public R createPerson(PN p1,PA p2);
//}
//public class Testyinyong{
//    public static void main(String[] args) {
//        IUtil<Person,String,Integer> iu=Person::new;
//        System.out.println(iu.createPerson("yusima",25));
//    }
//}