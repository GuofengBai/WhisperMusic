package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long>{

    

}