package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.FavoriteMusic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMusicDao extends JpaRepository<FavoriteMusic, Long> {

    List<FavoriteMusic> findByUserIdOrderByDateDesc(Long userId);

    void deleteByUserIdAndMusicId(Long userId, Long musicId);

    int countByUserIdAndMusicId(Long userId, Long musicId);

}
