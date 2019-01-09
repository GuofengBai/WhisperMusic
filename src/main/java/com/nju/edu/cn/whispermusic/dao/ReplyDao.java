package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyDao extends JpaRepository<Reply, Long> {

    Page<Reply> findAllByWhisperId(Long id, Pageable pageable);

    List<Reply> findTop5ByWhisperIdOrderByLikesDesc(Long whisperId);

    List<Reply> findByWhisperIdAndStickedIsTrue(Long whisperId);

    @Query("update Reply r set r.likes = r.likes+1 where r.id=:id")
    @Modifying
    void addLikes(@Param("id") Long id);

    @Query("update Reply r set r.sticked = true where r.id=:id")
    @Modifying
    void stickReply(@Param("id") Long id);

    @Query("update Reply r set r.sticked = false where r.id=:id")
    @Modifying
    void unstickReply(@Param("id") Long id);



}
