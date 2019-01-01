package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.Reply;
import org.springframework.data.domain.Page;

public interface ReplyService {

    Reply createReply(Long whisperId, Long ownerId, Reply reply);

    Page<Reply> getReplyList(Long whisperId, Integer page);

}
