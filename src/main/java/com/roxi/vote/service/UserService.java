package com.roxi.vote.service;

import com.roxi.vote.bean.User;
import com.roxi.vote.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roxi酱
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void doInt(){
        User user=new User();
        user.setOpenId("123");
        userMapper.insert(user);
        throw new RuntimeException();
    }

    public boolean judge(String openId){
        User user=new User();
        user.setOpenId(openId);
        if(null!=openId){
            User user1=userMapper.select(user);
            if(null!=user1){
                return true;
            }
            user.setTicket(5);
            userMapper.insert(user);
            return true;
        }else {
            return false;
        }
    }
}
