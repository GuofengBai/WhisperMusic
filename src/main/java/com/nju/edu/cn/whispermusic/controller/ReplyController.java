package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.service.ReplyService;
import com.nju.edu.cn.whispermusic.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/{replyId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteReply(@PathVariable("replyId") Long replyId) {
        replyService.deleteReply(replyId);
        return new Response<>("OK!", "delete reply-" + replyId + " successfully.", "");
    }

    @RequestMapping(value = "/{replyId}/like", method = RequestMethod.POST)
    @ResponseBody
    public Response likeReply(@PathVariable("replyId") Long replyId) {
        replyService.addLikes(replyId);
        return new Response<>("OK!", "add likes of reply-" + replyId + " successfully.", "");
    }

}
