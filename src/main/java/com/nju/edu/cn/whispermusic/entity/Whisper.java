package com.nju.edu.cn.whispermusic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Whisper{

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Date date;

    private Integer likes = 0;

    private Boolean hasMusic = false;

    private String musicName = "null";

    private String musicId = "null";

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    private User owner;

    @OneToMany(mappedBy = "whisper", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reply> replies = new HashSet<>();

    public Whisper() {
        this.date = new Date();
    }

    public Whisper(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public Whisper(String title, String content, String musicName, String musicId) {
        this.title = title;
        this.content = content;
        this.musicName = musicName;
        this.musicId = musicId;
        this.date = new Date();
        this.hasMusic = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getHasMusic() {
        return hasMusic;
    }

    public void setHasMusic(Boolean hasMusic) {
        this.hasMusic = hasMusic;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Whisper whisper = (Whisper) o;
        return id.equals(whisper.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}