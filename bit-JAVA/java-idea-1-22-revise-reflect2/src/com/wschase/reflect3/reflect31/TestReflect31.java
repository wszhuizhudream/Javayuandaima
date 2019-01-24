package com.wschase.reflect3.reflect31;

import java.lang.reflect.InvocationTargetException;

/**
 * Author:WSChase
 * Created:2019/1/23
 */
public class TestReflect31 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        String value="emp.ename:jack|emp.job:java Coder";
        EmpAction empAction=new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
