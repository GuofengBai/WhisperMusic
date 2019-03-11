package com.nju.edu.cn.whispermusic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MusicController {

    @RequestMapping(value="/searchmusic",method=RequestMethod.GET)
    public String loginPage(HttpSession session) {

        return "musicSearch";

    }


}
