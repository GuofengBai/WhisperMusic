package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.FavoriteWhisper;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.domain.Page;

public interface FavoriteWhisperService {

    boolean isFavoriteWhisperOfUser(Long userId, Long whisperId);

    FavoriteWhisper favorite(Long userId, Long whisperId);

    void unfavorite(Long favoriteWhisperId);

    void unfavorite(Long userId, Long whisperId);

    Page<Whisper> favoriteWhisperOfUser(Long userId, Integer page);

}
