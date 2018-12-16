package com.bittech.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Paths;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestSerializable {
    
    /*
        Java Object (In Memory) -> Binary Data
        
    1. Java提供的一种序列化(JDK提供) 远程方法调用(RPC)
       Object (In Memory) -> byte[]  (网络中传输，保存文件) 序列化
       byte[]             -> Object (In Memory) 反序列化
    
    2. Object  -> JSON (前端开发 JavaScript) Person(name,age) -> {"name":"Jack", "age": 22}
       JSON    -> Object
    
    3. Object -> XML (XML文件)(JDK提供)
       XML    -> Object
    
    
    
    4. Java序列化：
       4.1 序列化对象的属性信息
       4.2 反序列化不会执行构造方法和构造块
     */
    
    
    public static void code1() {
        //1.准备序列化输出的文件
        //2.准备要参与的序列化对象
        //3.业务操作（Object -> byte[]）
        
        File objFile = Paths.get("D:", "test", "person.obj").toFile();
        
        //内存中的Java对象
        Person person = new Person("Jack", 22, "jack@gmail.com");
        
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(objFile)
        )) {
            //文件中的二进制数据流
            out.writeObject(person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void code2() {
        File objFile = Paths.get("D:", "test", "person.obj").toFile();
        
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(objFile)
        )) {
            Person person = (Person) in.readObject();
            System.out.println(person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        code1();
        code2();
    
     
        
    }
    
    
}

//Serializable  标识接口
class Person implements Serializable {
    
    private String name;
    
    private Integer age;
    
    private transient String email;

//    {
//        System.out.println("Construct Block");
//    }
    
    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        //System.out.println("Person Construct");
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
