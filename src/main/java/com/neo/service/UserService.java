package com.neo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.UserDao;
import com.neo.domain.User;

@Service
public class UserService {
    
    @Autowired
        private User user;
    @Autowired
    private UserDao userDao;
//    @Autowired
//    private UserMapper userMapper;
    public User getUser(){
        return user;
    }
    public int addUserWithBackId(List<User> users){
        
        return userDao.insertUserWithBackId(users);//该方法后，主键已经设置到user中了
    }

    public List getUserByPage(){
//        PageHelper.startPage(1,5);
//        List list = userMapper.selectAll();
        return null;
    }
}