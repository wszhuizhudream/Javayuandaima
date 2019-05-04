package com.wschase.springcore.xml;

import com.wschase.springcore.common.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:WSChase
 * Created:2019/5/2
 */
public class XmlApplication {
    public static void main(String[] args) {
        //我们通过new的方式构建了一个容器
        ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
        //这个Bean就相当于是我们的对象，而getBean()方法就是get容器里面的对象
        XmlShapeCompute xmlShapeCompute= (XmlShapeCompute) context.getBean("xmlShapeCompute");//通过名字获取这个对象
        Shape shape=xmlShapeCompute.computeShape(args[0]);//当我们传进去参数以后容器根据这个参数的类型帮我们创建了对象
        System.out.println(shape);
    }
}
