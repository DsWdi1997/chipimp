package com.example.chipimp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping("/spring2")
    public String index1(){

        return "add";
    }
}
