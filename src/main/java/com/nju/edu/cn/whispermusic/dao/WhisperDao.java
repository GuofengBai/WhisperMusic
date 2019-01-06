package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.Whisper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WhisperDao extends JpaRepository<Whisper, Long> {

    Page<Whisper> findAll(Pageable pageable);

    Page<Whisper> findAllByOwnerId(Long id, Pageable pageable);

    @Query("update Whisper w set w.like = w.like+1 where w.id=:id")
    @Modifying
    void addLikes(@Param("id") Long id);

}
