package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.FavoriteMusicDao;
import com.nju.edu.cn.whispermusic.entity.FavoriteMusic;
import com.nju.edu.cn.whispermusic.service.FavoriteMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteMusicServiceImpl implements FavoriteMusicService {

    @Autowired
    private FavoriteMusicDao favoriteMusicDao;

    @Override
    public FavoriteMusic favorite(Long userId, Long musicId, String musicName) {
        if (!isFavoriteMusicOfUser(userId, musicId)) {
            FavoriteMusic favoriteMusic = new FavoriteMusic(userId, musicName, musicId);
            return favoriteMusicDao.save(favoriteMusic);
        }
        return null;
    }

    @Override
    public List<FavoriteMusic> getFavoriteMusicOfUser(Long userId) {
        return favoriteMusicDao.findByUserIdOrderByDateDesc(userId);
    }

    @Override
    public boolean isFavoriteMusicOfUser(Long userId, Long musicId) {
        return favoriteMusicDao.countByUserIdAndMusicId(userId, musicId) > 0;
    }

    @Override
    public void unfavorite(Long userId, Long musicId) {
        favoriteMusicDao.deleteByUserIdAndMusicId(userId, musicId);
    }
}
