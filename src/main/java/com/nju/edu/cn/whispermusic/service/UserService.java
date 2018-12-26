package com.nju.edu.cn.whispermusic.service;

import com.nju.edu.cn.whispermusic.entity.User;

public interface UserService{

    boolean isUsernameUsed(String username);

    Long register(String username, String password);

    User login(String username, String password);

    User getUser(Long id);
    
}