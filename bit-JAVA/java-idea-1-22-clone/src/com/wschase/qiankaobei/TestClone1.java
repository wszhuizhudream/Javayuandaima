package com.wschase.qiankaobei;

/**浅拷贝
 * Author:WSChase
 * Created:2019/1/22
 */
public class TestClone1 {

    public static void main(String[] args) {
        Teacher teacher=new Teacher("Peter","C");
        Student student=new Student("Jack",22,teacher);

        System.out.println("这是原Student");
        System.out.println(student);

        System.out.println("这是Clone的Student");
        try {
             Student cloneStudent = student.clone();
        System.out.println(cloneStudent);



            teacher.setNane("Tang");
            System.out.println("这是原Student");
            System.out.println(student);

            System.out.println("这是Clone的Student");
            System.out.println(cloneStudent);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        //注意：
        //teacher ->student
        //teacher ->cloneStudent

        //1.如果teacher的信息改变了，student和cloneStudent中关于teacher的信息都改变，说明teacher是共享的
        //2.如果teacher的信息改变了，student中关于teacher的信息都改变，cloneStudent中关于teacher的信息都未改变，
        // 说明teacher不是共享的

    }
}
