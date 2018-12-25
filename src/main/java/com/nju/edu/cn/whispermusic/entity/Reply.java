package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reply{

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    public User owner;

    public Date date;

    public String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}