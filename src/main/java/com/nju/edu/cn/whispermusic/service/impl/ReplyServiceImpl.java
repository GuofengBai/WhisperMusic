package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.ReplyDao;
import com.nju.edu.cn.whispermusic.entity.Reply;
import com.nju.edu.cn.whispermusic.entity.User;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Reply createReply(Long whisperId, Long ownerId, Reply reply) {
        Whisper whisper = new Whisper();
        whisper.setId(whisperId);
        User owner = new User();
        owner.setId(ownerId);
        reply.setWhisper(whisper);
        reply.setOwner(owner);
        return replyDao.save(reply);
    }

    @Override
    public Page<Reply> getReplyList(Long whisperId, Integer page) {
        return null;
    }

    @Override
    public void addLikes(Long id) {
        replyDao.addLikes(id);
    }

    @Override
    public void deleteReply(Long id) {
        replyDao.deleteById(id);
    }

    @Override
    public void stickReply(Long id) {
        replyDao.stickReply(id);
    }

    @Override
    public void unstickReply(Long id) {
        replyDao.unstickReply(id);
    }

    @Override
    public List<Reply> getTop5LikesReply(Long whisperId) {
        return replyDao.findTop5ByWhisperIdOrderByLikesDesc(whisperId);
    }

    @Override
    public List<Reply> getstickedReply(Long whisperId) {
        return replyDao.findByWhisperIdAndStickedIsTrue(whisperId);
    }

}
