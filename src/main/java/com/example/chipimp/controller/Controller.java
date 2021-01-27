package com.example.chipimp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/springbootdemo")
public class Controller {

    @RequestMapping("/spring1")
    public String index(Model model){
        model.addAttribute("msg","123");
        return "index";
    }

    @RequestMapping("/spring2")
    public String index1(){

        return "chip";
    }
}
