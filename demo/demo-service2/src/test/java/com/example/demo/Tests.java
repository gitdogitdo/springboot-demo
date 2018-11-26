package com.example.demo;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class Tests {

    @Resource
    private UserDao userDao;

    public static void main(String[] args) {
    }

    @Test
    public void testGetUser() {
        List<User> user;
        try{
          user = userDao.selectByPager();
        } catch (Exception e){

            System.out.println(e.getMessage());
        }

    }
}
