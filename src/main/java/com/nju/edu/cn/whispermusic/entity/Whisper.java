package com.nju.edu.cn.whispermusic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Whisper{

    @Id
    public Long id;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

}