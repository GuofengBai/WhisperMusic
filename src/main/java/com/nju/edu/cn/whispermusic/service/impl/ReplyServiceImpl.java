package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.ReplyDao;
import com.nju.edu.cn.whispermusic.entity.Reply;
import com.nju.edu.cn.whispermusic.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Reply createReply(Long whisperId, Long ownerId, Reply reply) {
        return null;
    }

    @Override
    public Page<Reply> getReplyList(Long whisperId, Integer page) {
        return null;
    }
}
