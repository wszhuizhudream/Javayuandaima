package com.wschase.spring.xml;

import com.wschase.spring.common.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**这是一个主类
 * Author:WSChase
 * Created:2019/4/17
 */
public class XmlApplication {
    public static void main(String[] args) {

        //我们通过new的方式创建了一个容器
        ApplicationContext context=
                new ClassPathXmlApplicationContext("application-context.xml");

        //在容器里面取找这个name（id）对应的对象，找到之后会将对象返回给我们:
        //           这个时候我们获取对象就没有通过new来创建对象
    XmlShapeCompute xmlShapeCompute= (XmlShapeCompute) context.getBean("xmlShapeCompute");

    Shape shape=xmlShapeCompute.computeShape(args[0]);
        System.out.println(shape);
    }

}
