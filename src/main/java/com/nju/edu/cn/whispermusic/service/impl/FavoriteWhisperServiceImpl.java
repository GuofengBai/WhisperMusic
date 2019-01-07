package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.FavoriteWhisperDao;
import com.nju.edu.cn.whispermusic.entity.FavoriteWhisper;
import com.nju.edu.cn.whispermusic.entity.User;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.FavoriteWhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavoriteWhisperServiceImpl implements FavoriteWhisperService {

    @Autowired
    private FavoriteWhisperDao favoriteWhisperDao;

    @Override
    public boolean isFavoriteWhisperOfUser(Long userId, Long whisperId) {
        return favoriteWhisperDao.countByUserIdAndWhisperId(userId, whisperId) > 0;
    }

    @Override
    public FavoriteWhisper favorite(Long userId, Long whisperId) {
        if (isFavoriteWhisperOfUser(userId, whisperId)) {
            return null;
        } else {
            User user = new User();
            user.setId(userId);
            Whisper whisper = new Whisper();
            whisper.setId(whisperId);
            FavoriteWhisper favoriteWhisper = new FavoriteWhisper(user, whisper);
            return favoriteWhisperDao.save(favoriteWhisper);
        }
    }

    @Override
    public void unfavorite(Long favoriteWhisperId) {
        favoriteWhisperDao.deleteById(favoriteWhisperId);
    }

    @Override
    public void unfavorite(Long userId, Long whisperId) {
        favoriteWhisperDao.deleteByUserIdAndWhisperId(userId, whisperId);
    }

}
