package com.wschase.duotai;

/**
 * Author:WSChase
 * Created:2019/2/7
 */

class Person1{
    public void print1() {
        System.out.println("父类");
    }
}

class Student1 extends Person1{
    public void print1(){//方法覆写
        System.out.println("子类");
    }


    public void fun(){
        System.out.println("只有子类有");
    }
}
public class TestDuotai2 {
    public static void main(String[] args) {
        Person1 per1=new Student1();
        per1.print1();
        //此时我们的父类能够调用的方法之只能是本类帝国一好的方法
        //所以并没有Student类中的fun()方法，那么只能进行向下转型
        //注意：但是我们需要注意要实现向下转型的前提是之两个类之间一定有关系
        //并且已经实现了向上转型的才可以实现向下转型。

        Student1 stu= (Student1) per1;
        stu.fun();

        //那么如果我们没有实现向上转型直接实现向下转型，那么最好的办法就是通过
        //instanceof来判断这两个类之间是否有子类父类的关系。
    }
}
