package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.FavoriteWhisper;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteWhisperDao extends JpaRepository<FavoriteWhisper, Long> {

    @Query(value = "select fw.whisper from FavoriteWhisper fw where fw.user.id=:userId",
            countQuery = "select count(fw.whisper) from FavoriteWhisper fw where fw.user.id=:userId")
    Page<Whisper> getFavoriteWhisperOfUser(@Param("userId") Long userId, Pageable pageable);

    int countByUserIdAndWhisperId(Long userId, Long whisperId);

    void deleteByUserIdAndWhisperId(Long userId, Long whisperId);

    void deleteByUserId(Long userId);

    void deleteByWhisperId(Long whisperId);

}
