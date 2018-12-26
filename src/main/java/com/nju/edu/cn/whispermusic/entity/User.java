package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User{

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @OneToMany(mappedBy="owner",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Whisper> whispers;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reply> replies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Whisper> getWhispers() {
        return whispers;
    }

    public void setWhispers(Set<Whisper> whispers) {
        this.whispers = whispers;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }
}