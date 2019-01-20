package com.wschase.reflect;

/**作业：
 * Person类
 * String name;
 * Integer age;
 * Date birthday;
 *
 *
 * Person a=new Person();
 * a.setName(xx);
 *
 * Person b=new Person();
 * BeanCopy(Person a,Person b){
 * }
 * 再写一个工具类提供一个方法：当传入两个对象（a、b）的时候，将A里面属性的值全面拷贝到b里面去
 * Author:WSChase
 * Created:2019/1/19
 */
public class Person {
    private String ename;
    private Integer age;
    private String birthday;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
