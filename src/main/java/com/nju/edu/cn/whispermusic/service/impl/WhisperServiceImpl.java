package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.WhisperDao;
import com.nju.edu.cn.whispermusic.entity.Whisper;
import com.nju.edu.cn.whispermusic.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WhisperServiceImpl implements WhisperService {

    @Autowired
    private WhisperDao whisperDao;

    @Override
    public Page<Whisper> getWhisperList(Integer page) {

        return null;
    }

    @Override
    public Page<Whisper> getWhisperListOfUser(Long userId, Integer page) {
        return null;
    }

    @Override
    public Whisper createWhisper(Whisper whisper) {
        return null;
    }

    @Override
    public Whisper getWhisper(Long id) {
        return null;
    }

    @Override
    public void deleteWhisper(Long id) {

    }
}
