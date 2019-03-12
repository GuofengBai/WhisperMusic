package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FavoriteMusic {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String musicName;

    private String musicId;

    public FavoriteMusic(Long userId, String musicName, String musicId) {
        this.userId = userId;
        this.musicName = musicName;
        this.musicId = musicId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
