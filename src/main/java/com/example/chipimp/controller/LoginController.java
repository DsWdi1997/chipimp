package com.example.chipimp.controller;

import com.example.chipimp.pojo.Chip;
import com.example.chipimp.pojo.User;
import com.example.chipimp.service.ChipService;
import com.example.chipimp.service.UserService;
import com.example.chipimp.util.Loginformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    private Loginformation loginformation = new Loginformation();

    @Autowired
    private ChipService chipService ;


    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping(value = "/checkUser" , method = RequestMethod.POST)
    public String checkUser(@ModelAttribute(value = "user") User user, HttpServletRequest request , HttpServletResponse response) throws IOException {
        String userName = user.getUser_name();
        String passWord = user.getUser_passwd();
        List<User> users = userService.selectUser();
        response.setContentType("text/html;charset=utf-8");
        loginformation.rqsheaderlog(request,response);
        for (User tempuser : users) {
            if (tempuser.getUser_name().equals(userName) & tempuser.getUser_passwd().equals(passWord)){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return "index";
            }
        }
        return "error";
    }


}
