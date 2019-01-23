package com.wschase.shenkeobei;

/**深拷贝
 * Author:WSChase
 * Created:2019/1/22
 */
public class Clone2 {

    public static void main(String[] args) {
        Teacher teacher=new Teacher("Peter","C");
        Student student=new Student("Jack",22,teacher);

        System.out.println("这是原Student");
        System.out.println(student);

        System.out.println("这是Clone的Student");
            Student cloneStudent = student.cloneStudent();
            if (cloneStudent!=null){

            System.out.println(cloneStudent);

            teacher.setNane("Tang");
            System.out.println("这是原Student");
            System.out.println(student);

            System.out.println("这是Clone的Student");
            System.out.println(cloneStudent);
            }
    }
}
