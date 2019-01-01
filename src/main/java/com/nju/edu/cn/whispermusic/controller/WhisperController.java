package com.nju.edu.cn.whispermusic.controller;

import com.nju.edu.cn.whispermusic.service.ReplyService;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whisper")
public class WhisperController {

    @Autowired
    private WhisperService whisperService;

    @Autowired
    private ReplyService replyService;


}
