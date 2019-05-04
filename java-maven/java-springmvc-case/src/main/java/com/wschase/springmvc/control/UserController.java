package com.wschase.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;

/**
 * Author:WSChase
 * Created:2019/4/27
 */
@Controller
@RequestMapping(value = "/user")
//只要是以/user的url都可以到达这个UserController的里面进行处理
public class UserController {

    private static final String CURRENT_USER="current_user";

    //方法中的这个 ModelAndView返回值表示一个页面，表示访问这个地址就返回一个页面，展示在前端
    // 你只要访问这个/user/login这个地址我就能够用login()这个方法进行处理并且返回home.jsp这个页面
    //POST表示有正文，就是对我们用户提交的一些数据进行处理
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public ModelAndView login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("login username="+username+",password="+password);
        HttpSession session=request.getSession();
        session.setAttribute(CURRENT_USER,username);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("username",username);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"},method = {RequestMethod.GET})//只要你GET一下就会返回一个登录页面
    //这个表示以这三个开头的都可以到这个方法里面
    //ModelAndView就表示页面，即返回welcome这个页面
    public ModelAndView index(@CookieValue(value = "remind",required = false,defaultValue = "")String username){
        ModelAndView modelAndView=new ModelAndView();
        if(StringUtils.isEmpty(username)){

        modelAndView.setViewName("welcome");//WEB-INF/views/login.jsp
        }else {
            modelAndView.addObject("username",username);
            modelAndView.setViewName("home");
        }
        //返回一个页面
        return modelAndView;
    }

    //所有的超链接都是GET请求
    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    public ModelAndView logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        //Spring可以有一个session我们就不需要再创建session了
        session.removeAttribute(CURRENT_USER);//清理当前用户
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");//WEB-INF/views/login.jsp
        //返回一个页面
        return modelAndView;
    }




    /**
     * upload实现上传文件
     * @param multipartFile
     * @return
     */

    //只是为了获取页面
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }

    @RequestMapping(value = "/upload")
    public ModelAndView upload(@RequestPart(value = "head") MultipartFile multipartFile){//这个参数表示附件,一般我们的参数需要通过@RequestParam，但是因为它是附件所以我们单独处理了一下
        ModelAndView modelAndView=new ModelAndView();
        try {
            //获取到这个文件的字节数
            byte[] data=multipartFile.getBytes();
            //将byte数组转化为base64编码:在JDK1.8以后在这个Base64编码，这个是还是中国人实现的
            String dataString=Base64.getEncoder().encodeToString(data);
            //取后缀
            String extend=multipartFile.getOriginalFilename().substring(
                    multipartFile.getOriginalFilename().lastIndexOf(".")+1
            );
            String base64Value=String.format("data:image/%s;base64,%s",extend,dataString);
            modelAndView.addObject("head_data",base64Value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("upload");
        return modelAndView;
    }
}
