package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.Reply;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReplyService {

    Reply createReply(Long whisperId, Long ownerId, Reply reply);

    Page<Reply> getReplyList(Long whisperId, Integer page);

    void addLikes(Long id);

    void deleteReply(Long id);

    void stickReply(Long id);

    void unstickReply(Long id);

    List<Reply> getTop5LikesReply(Long whisperId);

    List<Reply> getstickedReply(Long whisperId);

}
