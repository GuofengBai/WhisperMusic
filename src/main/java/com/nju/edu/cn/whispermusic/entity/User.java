package com.nju.edu.cn.whispermusic.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue
    public Long id;

    public String username;

    public String password;

    @OneToMany(mappedBy="owner",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Whisper> whispers;

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

}