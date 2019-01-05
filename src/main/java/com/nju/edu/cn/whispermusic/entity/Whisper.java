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