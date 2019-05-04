package com.wschase.boot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**通过spring发送邮件
 * Author:WSChase
 * Created:2019/4/29
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

//    @RequestMapping(value = "/basic1,/basic2")
//    public String mail1(){
//        try {
//            sendBasic1();
//            return "success";
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return "falie";
//        }
//    }

    @RequestMapping(value = "/basic2")
    public String mail2(){
        try {
            sendBasic2();
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "falie";
        }
    }


    /**
     * 1.发送邮件：简单文本方式
     * @throws MessagingException
     */
//    public void sendBasic1() throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        mimeMessage.setRecipient(
//                Message.RecipientType.TO,
//                new InternetAddress("1041646364@qq.com")
//        );
//        mimeMessage.setFrom(new InternetAddress("1286072183@qq.com"));
//        mimeMessage.setSubject("SpringBoot send email by style1");
//        mimeMessage.setText("Hello this is a simple mail.");
//        mailSender.send(mimeMessage);
//    }

    /**
     * 2.发送邮件
     * throws MessagingException
     */
    public void sendBasic2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("1286072183@qq.com");
        helper.setTo("939694006@qq.com");
        //抄送给谁
        helper.setBcc("");
        helper.setSubject("SpringBoot send email by style2");
        helper.setText("Hello this is a simple mail.");
        mailSender.send(mimeMessage);
    }


}
