package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.FavoriteWhisperDao;
import com.nju.edu.cn.whispermusic.dao.WhisperDao;
import com.nju.edu.cn.whispermusic.entity.User;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WhisperServiceImpl implements WhisperService {

    @Autowired
    private WhisperDao whisperDao;

    @Autowired
    private FavoriteWhisperDao favoriteWhisperDao;

    private static Integer pageSize = 20;

    @Override
    public Page<Whisper> getWhisperList(Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "like");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return whisperDao.findAll(pageable);
    }

    @Override
    public Page<Whisper> getWhisperListOfUser(Long userId, Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "date");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return whisperDao.findAllByOwnerId(userId, pageable);
    }

    @Override
    public Whisper createWhisper(Long ownerId, Whisper whisper) {
        User owner = new User();
        owner.setId(ownerId);
        whisper.setOwner(owner);
        return whisperDao.save(whisper);
    }

    @Override
    public Whisper getWhisper(Long id) {
        Whisper whisper = whisperDao.getOne(id);
        //显式访问并加载replies属性；否则由于hibernate懒加载，到页面后，whisper中没有replies
        whisper.getReplies();
        return whisper;
    }

    @Override
    public void deleteWhisper(Long id) {
        whisperDao.deleteById(id);
        favoriteWhisperDao.deleteByWhisperId(id);
    }

    @Override
    public void addLikes(Long id) {
        whisperDao.addLikes(id);
    }
}
