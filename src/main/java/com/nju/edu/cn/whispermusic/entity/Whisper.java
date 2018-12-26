package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Whisper{

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Date date;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    private User owner;

    @OneToMany(mappedBy = "whisper", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reply> replies;

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

}