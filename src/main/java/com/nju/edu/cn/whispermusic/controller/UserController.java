package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.entity.FavoriteMusic;
import com.nju.edu.cn.whispermusic.entity.Reply;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private FavoriteMusicService favoriteMusicService;

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
        Long userId = (Long) session.getAttribute("userId");
        boolean isFavoriteWhisperOfUser = favoriteWhisperService.isFavoriteWhisperOfUser(userId, whisperId);
        model.addAttribute("isFavoriteWhisperOfUser", isFavoriteWhisperOfUser);
        List<Reply> top5LikesReply = replyService.getTop5LikesReply(whisperId);
        model.addAttribute("top5LikesReply", top5LikesReply);
        List<Reply> stickedReply = replyService.getstickedReply(whisperId);
        model.addAttribute("stickedReply", stickedReply);
        return "replyManage";
    }

    @RequestMapping(value = "/FavoriteWhisper", method = RequestMethod.GET)
    public String favoriteWhisperPage(HttpSession session, Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        Long userId = (Long) session.getAttribute("userId");
        Page<Whisper> whisperPage = favoriteWhisperService.favoriteWhisperOfUser(userId, page);
        model.addAttribute("page", whisperPage);
        return "favoriteWhisper";
    }

    @RequestMapping(value = "/FavoriteMusic", method = RequestMethod.GET)
    public String favoriteMusicPage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        List<FavoriteMusic> favoriteMusics = favoriteMusicService.getFavoriteMusicOfUser(userId);
        model.addAttribute("favoriteMusic", favoriteMusics);
        return "favoriteMusic";
    }

}
