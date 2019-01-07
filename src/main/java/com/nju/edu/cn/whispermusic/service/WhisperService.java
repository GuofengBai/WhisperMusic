package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.domain.Page;

public interface WhisperService {

    Page<Whisper> getWhisperList(Integer page);

    Page<Whisper> getWhisperListOfUser(Long userId, Integer page);

    Whisper createWhisper(Long ownerId, Whisper whisper);

    Whisper getWhisper(Long id);

    void deleteWhisper(Long id);

    void addLikes(Long id);

}
