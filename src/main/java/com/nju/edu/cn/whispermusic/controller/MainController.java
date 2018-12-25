package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController{

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginPage(){

        return "login";
        
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String registerPage(){

        return "register";
        
    }


}