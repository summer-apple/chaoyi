package com.drartisan.service.impl;

import com.drartisan.dao.UserMapper;
import com.drartisan.entity.User;
import com.drartisan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by summer on 16-8-12.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        int count = userMapper.checkUsername(username);
        if(count > 0){
            return userMapper.checkPassword(username,password);
        }

        return null;
    }

    @Override
    public int register(User user) {
        user.setRegTime(new Date());
        return userMapper.addUser(user);
    }

    @Override
    public User getById(int id) {

        return userMapper.getUserById(id);
    }

    @Override
    public boolean update(User user) {
        try {
            userMapper.update(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
