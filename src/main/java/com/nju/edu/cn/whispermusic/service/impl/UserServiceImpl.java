package com.nju.edu.cn.whispermusic.service.impl;

import com.nju.edu.cn.whispermusic.dao.UserDao;
import com.nju.edu.cn.whispermusic.entity.User;
import com.nju.edu.cn.whispermusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public boolean isUsernameUsed(String username) {
        List<User> userList = userDao.findByUsername(username);
        return userList.size() > 0;
    }

    @Override
    public Long register(String username, String password) {
        User newUser = new User(username, password);
        newUser = userDao.save(newUser);
        return newUser.getId();
    }

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getOne(id);
    }
}