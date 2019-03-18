package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class FavoriteMusic {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String musicName;

    private Long musicId;

    private Date date;

    public FavoriteMusic(){
    }

    public FavoriteMusic(Long userId, String musicName, Long musicId) {
        this.userId = userId;
        this.musicName = musicName;
        this.musicId = musicId;
        this.date = new Date();
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

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
