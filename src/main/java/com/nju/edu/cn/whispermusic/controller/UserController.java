package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.ReplyService;
import com.nju.edu.cn.whispermusic.service.UserService;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WhisperService whisperService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userHomePage(HttpSession session) {
        return "userHome";
    }

    @RequestMapping(value = "/whisper", method = RequestMethod.GET)
    public String whisperManagePage(HttpSession session, Model model, @RequestParam(required = false, defaultValue = "1") Integer page) {
        Long userId = (Long) session.getAttribute("userId");
        Page<Whisper> whisperPage = whisperService.getWhisperListOfUser(userId, page);
        model.addAttribute("page", whisperPage);
        return "whisperManage";
    }

}
