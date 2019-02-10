package com.wschase.duotai;

/**多态——对象多态性
 * Author:WSChase
 * Created:2019/2/7
 */
//观察向上转型
    class Person{
        public void print() {
            System.out.println("父类");
        }
}

class Student extends Person{
        public void print(){//方法覆写
            System.out.println("子类");
        }
}
public class TestDuotai {
    public static void main(String[] args) {
        Person per=new Student();//实现向上转型
        per.print();//真正实例化的对象是Student的，并且经过了方法覆写的
                    //所以此时调用的方法是Student的
    }
}
