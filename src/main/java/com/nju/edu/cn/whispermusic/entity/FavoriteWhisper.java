package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FavoriteWhisper {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Whisper whisper;

    public FavoriteWhisper() {
    }

    public FavoriteWhisper(User user, Whisper whisper) {
        this.user = user;
        this.whisper = whisper;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Whisper getWhisper() {
        return whisper;
    }

    public void setWhisper(Whisper whisper) {
        this.whisper = whisper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteWhisper that = (FavoriteWhisper) o;
        return user.equals(that.user) &&
                whisper.equals(that.whisper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, whisper);
    }
}
