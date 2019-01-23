package com.wschase.shenkeobei;

import java.io.*;

/**
 * Author:WSChase
 * Created:2019/1/22
 */
public class Student implements Cloneable,Serializable {
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


    //浅拷贝
    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student=null;
        student=(Student)super.clone();
        return student;
    }

    //深拷贝
    public Student cloneStudent(){

        try(ByteArrayOutputStream out=new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            ) {
            //写入
            objOut.writeObject(this);//this->student对象
            try (
                    ByteArrayInputStream input=new ByteArrayInputStream(out.toByteArray());
                    ObjectInputStream objInput = new ObjectInputStream(input)) {

                //读取
                Student student = (Student) objInput.readObject();
                return student;
            }catch (IOException ignored){
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

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
