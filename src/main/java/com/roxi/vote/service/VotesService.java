package com.roxi.vote.service;

import com.roxi.vote.bean.Entiy;
import com.roxi.vote.bean.User;
import com.roxi.vote.bean.Votes;
import com.roxi.vote.mapper.EntiyMapper;
import com.roxi.vote.mapper.UserMapper;
import com.roxi.vote.mapper.VotesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Roxi酱
 */
@Service
public class VotesService {
    @Resource
    private VotesMapper votesMapper;
    @Resource
    private EntiyMapper entiyMapper;
    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public boolean add(@NotNull Entiy entiy,@NotNull User user){
      String entiyName=entiy.getName();
      user=userMapper.select(user);
      int tickets=user.getTicket();
      if(tickets-1<0){
          return false;
      }
      userMapper.update(user);
      entiy=entiyMapper.select(entiyName);
      entiyMapper.update(entiy);
      String timestamp= String.valueOf(System.currentTimeMillis());
      Votes votes=new Votes();
      votes.setEntiyId(entiy.getId());
      votes.setUid(user.getId());
      votes.setTimestamp(timestamp);
      votesMapper.insert(votes);
      System.out.println(votes.getId());
      return true;
    }
}
