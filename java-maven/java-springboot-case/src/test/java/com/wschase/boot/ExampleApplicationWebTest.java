package com.wschase.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
@RunWith(SpringRunner.class)
//在SpringBootTest里面添加的信息表示要测试web
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//我们采用随机端口号，这样测试的时候就不会出现端口号占用的情况
public class ExampleApplicationWebTest {

    @Autowired
    private TestRestTemplate testRestTemplate;//注入这个类

    //测试一下发送文本信息的邮件
    @Test
    public void test1(){
       ResponseEntity<String> stringResponseEntity = testRestTemplate.getForEntity("http://localhost:80/mail/basic1",String.class);
            Assert.assertEquals(HttpStatus.OK,stringResponseEntity.getStatusCode());
            Assert.assertEquals("success",stringResponseEntity.getBody());
    }
}
