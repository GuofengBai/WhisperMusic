package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhisperDao extends JpaRepository<Whisper, Long> {

    Page<Whisper> findAll(Pageable pageable);

    Page<Whisper> findAllByOwnerId(Long id, Pageable pageable);

}
