package com.wschase.reflect3.reflect31;

import java.lang.reflect.InvocationTargetException;

/**
 * Author:WSChase
 * Created:2019/1/23
 */
public class EmpAction {
    private Emp emp=new Emp();

    public void setValue(String value) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        BeanOperation.setBeanValue(this,value);
    }

    public Emp getEmp(){
        return emp;
    }
}
