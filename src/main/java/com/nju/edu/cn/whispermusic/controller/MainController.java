package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.entity.User;
import com.nju.edu.cn.whispermusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController{

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginPage(HttpSession session) {

        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) {
        User user = userService.login(username, password);
        if (user == null) {
            return "error";
        } else {
            session.setAttribute("userId", user.getId());
            return "redirect:/user/";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(HttpSession session) {

        return "register";

    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(HttpSession session, String username, String password) {

        if (userService.isUsernameUsed(username)) {
            return "error";
        } else {
            Long id = userService.register(username, password);
            session.setAttribute("userId", id);
            return "redirect:/user/";
        }

    }


}