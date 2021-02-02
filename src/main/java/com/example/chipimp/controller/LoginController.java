package com.example.chipimp.controller;

import com.example.chipimp.pojo.User;
import com.example.chipimp.service.UserService;
import com.example.chipimp.util.Loginformation;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private     DefaultKaptcha defaultKaptcha;

    private Loginformation loginformation = new Loginformation();



    @RequestMapping({"/","/toLogin"})
    public String toLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }


    //获取验证码
    @RequestMapping("/getCode")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    //验证登录信息

    @RequestMapping(value = "/checkUser" , method = RequestMethod.POST)
    public Object checkUser(@ModelAttribute(value = "user") User user, HttpServletRequest request , HttpServletResponse response) throws IOException {
        String userName = user.getUser_name();
        String passWord = user.getUser_passwd();
        HashMap<String,Object> map = new HashMap<String,Object>();
        String captchaId = (String) request.getSession().getAttribute("vrifyCode");
        String parameter = request.getParameter("code");
        System.out.println("Session  vrifyCode ---->"+captchaId+"---- form code --->"+parameter);

        List<User> users = userService.selectUser();
        response.setContentType("text/html;charset=utf-8");
        loginformation.rqsheaderlog(request,response);

        for (User tempuser : users) {
            if (tempuser.getUser_name().equals(userName) & tempuser.getUser_passwd().equals(passWord) & captchaId.equals(parameter)){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return "homepage";
            }
        }
        return "login";

    }




}
