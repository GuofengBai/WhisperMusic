package com.nju.edu.cn.whispermusic.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Whisper{

    @Id
    @GeneratedValue
    public Long id;

    public String title;

    public String content;

    public Date date;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    public User owner;

    @OneToMany(mappedBy="owner",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Reply> replies;

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

}