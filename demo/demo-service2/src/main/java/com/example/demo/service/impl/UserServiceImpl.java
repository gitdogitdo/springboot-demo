package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByPK(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectList() {
        return userDao.selectByPager();
    }

    @Override
    public int update(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(String id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
