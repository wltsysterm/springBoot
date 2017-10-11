package com.neo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neo.domain.User;

@Repository
public class UserDao {
    
//    @Autowired
//    private UserMapper userMapper;
    
    public int insertUser(String username, String password){
     return 1;
//        return userMapper.insertUser(username, password);
    }
    
    public int insertUserWithBackId(List<User> users){    
//        return userMapper.insertUser(user.get);
    	for(User user:users){
    		System.out.println(user.getPassword());
        	System.out.println(user.getUsername());	
    	}
    	//通过mybatis往数据库里面插入一条数据
//    	return userMapper.insertUserWithBackId(users.get(0));
        return 1;
    }
    
}
