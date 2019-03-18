package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.FavoriteMusic;

import java.util.List;

public interface FavoriteMusicService {

    FavoriteMusic favorite(Long userId, Long musicId, String musicName);

    List<FavoriteMusic> getFavoriteMusicOfUser(Long userId);

    boolean isFavoriteMusicOfUser(Long userId, Long musicId);

    void unfavorite(Long userId, Long musicId);

}
