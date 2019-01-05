package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.entity.Reply;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.ReplyService;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import com.nju.edu.cn.whispermusic.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/whisper")
public class WhisperController {

    @Autowired
    private WhisperService whisperService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String whisperListPage(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        Page<Whisper> whisperPage = whisperService.getWhisperList(page);
        model.addAttribute("page", whisperPage);
        return "whisperList";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createWhisper(HttpSession session, String title, String content) {
        Whisper whisper = new Whisper(title, content);
        Long userId = (Long) session.getAttribute("userId");
        whisper = whisperService.createWhisper(userId, whisper);
        if (whisper != null) {
            return "redirect:/whisper/" + whisper.getId();
        } else {
            return "redirect:/whisper";
        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createWhisperPage() {
        return "newWhisper";
    }

    @RequestMapping(value = "/{whisperId}", method = RequestMethod.GET)
    public String whisperDetailPage(Model model, @PathVariable("whisperId") Long whisperId) {
        //Whisper whisper = whisperService.getWhisper(whisperId);
        //model.addAttribute("whisper", whisper);
        return "whisperDetail";
    }

    @RequestMapping(value = "/{whisperId}/delete", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteWhisper(Model model, @PathVariable("whisperId") Long whisperId) {
        whisperService.deleteWhisper(whisperId);
        return new Response<>("OK!", "delete whisper-" + whisperId + " successfully.", "");
    }

    @RequestMapping(value = "/{whisperId}/replies/", method = RequestMethod.POST)
    public String createReply(HttpSession session, @PathVariable("whisperId") Long whisperId, String content) {
        Long userId = (Long) session.getAttribute("userId");
        Reply reply = new Reply(content);
        reply = replyService.createReply(whisperId, userId, reply);
        return "redirect:/whisper/" + whisperId;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Page testWhisperListPage(Model model, @RequestParam(required = false, defaultValue = "1") Integer page) {
        Page<Whisper> whisperPage = whisperService.getWhisperList(page);
        return whisperPage;
    }

}
