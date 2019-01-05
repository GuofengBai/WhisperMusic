package com.nju.edu.cn.whispermusic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reply{

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    private User owner;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Whisper whisper;

    private Date date;

    private String content;

    public Reply() {
        this.date = new Date();
    }

    public Reply(String content) {
        this.date = new Date();
        this.content = content;
    }

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

    public Whisper getWhisper() {
        return whisper;
    }

    public void setWhisper(Whisper whisper) {
        this.whisper = whisper;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return id.equals(reply.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}