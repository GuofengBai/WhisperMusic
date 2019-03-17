package com.nju.edu.cn.whispermusic.controller;


import com.nju.edu.cn.whispermusic.vo.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MusicController {

    @RequestMapping(value="/searchmusic",method=RequestMethod.GET)
    public String loginPage(HttpSession session) {

        return "musicSearch";

    }



    @RequestMapping(value = "/music/{whisperId}/favorite", method = RequestMethod.POST)
    @ResponseBody
    public Response favoriteWhisper(HttpSession session, @PathVariable("whisperId") Long whisperId) {
        Long userId = (Long) session.getAttribute("userId");

        return null;
    }

    @RequestMapping(value = "/music/{whisperId}/unfavorite", method = RequestMethod.POST)
    @ResponseBody
    public Response unfavoriteWhisper(HttpSession session, @PathVariable("whisperId") Long whisperId) {
        Long userId = (Long) session.getAttribute("userId");

        return null;
    }



}
