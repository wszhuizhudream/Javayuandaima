package com.wschase.qiankaobei;

/**注意：
 * 一个类的实例化对象要能够克隆得实现Cloneable接口
 * Author:WSChase
 * Created:2019/1/22
 */
public class Student implements Cloneable{
    private String name;

    private Integer age;

    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student=null;
        student=(Student)super.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
}
