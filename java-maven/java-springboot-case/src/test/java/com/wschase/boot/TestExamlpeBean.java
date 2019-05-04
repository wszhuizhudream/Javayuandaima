package com.wschase.boot;

import com.wschase.boot.component.ExampleBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestExamlpeBean {
    @Autowired
    private ExampleBean exampleBean;

    @Test
    public void test1(){
        //true
        Assert.assertEquals("jack",exampleBean.getName());
    }

    @Test
    public void test2(){
        //false
        Assert.assertEquals("jack2",exampleBean.getName());
    }
}
