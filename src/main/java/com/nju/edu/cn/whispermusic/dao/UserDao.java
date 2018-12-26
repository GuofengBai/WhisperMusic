package com.nju.edu.cn.whispermusic.dao;

import com.nju.edu.cn.whispermusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long>{

    User findByUsernameAndPassword(String username, String password);

    List<User> findByUsername(String username);

}