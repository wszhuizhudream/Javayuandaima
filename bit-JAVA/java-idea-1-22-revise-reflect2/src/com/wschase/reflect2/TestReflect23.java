package com.wschase.reflect2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**2.3反射调用普通方法（核心）
 * Author:WSChase
 * Created:2019/1/23
 */

class Person1{
    private String name;

    private int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestReflect23 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c=Person.class;//获取Class对象

        //1.获取一个类中的全部方法
        Method[] methods=c.getMethods();
        for(Method method:methods){
            System.out.println(method);

        //2.通过反射调用getter、setter方法
        Class<?> cls=Class.forName("com.wschase.reflect2.Person");
        //任何时候调用类中的普通方法都必须有实例化对象
        Object obj=cls.newInstance();
        //取得setName这个方法的实例化对象，设置方法名称于参数类型
            Method setMethod=cls.getMethod("setName",String.class);
            //随后需要通过Method类对象调用指定的方法，调用方法需要有实例化对象
            //同时传入参数
            setMethod.invoke(obj,"jack");//相当于Person对象.setName("jack");
            Method getMethod = cls.getMethod("getName");
            Object result=getMethod.invoke(obj);//相当于Person对象.getName()
            System.out.println(result);
        }
    }
}
