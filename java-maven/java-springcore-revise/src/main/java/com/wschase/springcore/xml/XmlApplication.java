package com.wschase.springcore.xml;

import com.wschase.springcore.common.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:WSChase
 * Created:2019/5/4
 */
public class XmlApplication {
    public static void main(String[] args) {
        //此时我们创建对象的时候不需要new对象了，直接创建一个容器容器帮我们创建对象:容器会到我们的配置文件中找对应的对象
        ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
        //下面就是创建对象
        XmlShapeCompute xmlShapeCompute= (XmlShapeCompute) context.getBean("xmlShapeCompute");
        Shape shape=xmlShapeCompute.computeShape(args[0]);
        System.out.println(shape);
    }

}
