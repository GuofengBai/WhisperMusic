package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.FavoriteWhisperService;
import com.nju.edu.cn.whispermusic.service.ReplyService;
import com.nju.edu.cn.whispermusic.service.UserService;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private FavoriteWhisperService favoriteWhisperService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userHomePage(HttpSession session) {
        return "userHome";
    }

    @RequestMapping(value = "/whisper", method = RequestMethod.GET)
    public String whisperManagePage(HttpSession session, Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        Long userId = (Long) session.getAttribute("userId");
        Page<Whisper> whisperPage = whisperService.getWhisperListOfUser(userId, page);
        model.addAttribute("page", whisperPage);
        return "whisperManage";
    }

    @RequestMapping(value = "/whisper/{whisperId}", method = RequestMethod.GET)
    public String whisperReplyManagePage(HttpSession session, Model model,  @PathVariable("whisperId") Long whisperId) {
        Whisper whisper = whisperService.getWhisper(whisperId);
        model.addAttribute("whisper", whisper);
        return "replyManage";
    }

    @RequestMapping(value = "/FavoriteWhisper", method = RequestMethod.GET)
    public String favoriteWhisperPage(HttpSession session, Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        Long userId = (Long) session.getAttribute("userId");
        Page<Whisper> whisperPage = favoriteWhisperService.favoriteWhisperOfUser(userId, page);
        model.addAttribute("page", whisperPage);
        return "favoriteWhisper";
    }

}
