package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyDao extends JpaRepository<Reply, Long> {

    Page<Reply> findAllByWhisperId(Long id, Pageable pageable);

}
