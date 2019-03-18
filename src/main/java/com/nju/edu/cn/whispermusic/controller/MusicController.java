package com.nju.edu.cn.whispermusic.controller;


import com.nju.edu.cn.whispermusic.service.FavoriteMusicService;
import com.nju.edu.cn.whispermusic.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MusicController {

    @Autowired
    private FavoriteMusicService favoriteMusicService;

    @RequestMapping(value="/searchmusic",method=RequestMethod.GET)
    public String loginPage(HttpSession session) {

        return "musicSearch";

    }

    @RequestMapping(value = "/music/{musicId}/favorite", method = RequestMethod.POST)
    @ResponseBody
    public Response favoriteWhisper(HttpSession session, @PathVariable("musicId") Long musicId, @RequestParam String musicName) {
        Long userId = (Long) session.getAttribute("userId");
        favoriteMusicService.favorite(userId, musicId, musicName);
        return new Response<>("OK!", "user-" + userId + " favorite music " + musicName + " successfully.", "");
    }

    @RequestMapping(value = "/music/{musicId}/unfavorite", method = RequestMethod.POST)
    @ResponseBody
    public Response unfavoriteWhisper(HttpSession session, @PathVariable("musicId") Long musicId) {
        Long userId = (Long) session.getAttribute("userId");
        favoriteMusicService.unfavorite(userId, musicId);
        return new Response<>("OK!", "user-" + userId + " unfavorite music-" + musicId + " successfully.", "");
    }

}
