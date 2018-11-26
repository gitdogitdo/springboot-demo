package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User selectByPK(String id);

    List<User> selectList();

    int update(User user);

    int delete(String id);
}
