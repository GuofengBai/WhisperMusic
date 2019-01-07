package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.FavoriteWhisper;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteWhisperDao extends JpaRepository<FavoriteWhisper, Long> {

    @Query("select fw.whisper from FavoriteWhisper fw where fw.user.id=:userId")
    List<Whisper> getFavoriteWhisperOfUser(@Param("userId") Long userId);

    int countByUserIdAndWhisperId(Long userId, Long whisperId);

    void deleteByUserIdAndWhisperId(Long userId, Long whisperId);

    void deleteByUserId(Long userId);

    void deleteByWhisperId(Long whisperId);

}
