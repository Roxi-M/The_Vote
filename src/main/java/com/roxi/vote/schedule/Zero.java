package com.roxi.vote.schedule;

import com.roxi.vote.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Roxi酱
 */
@Component
@EnableScheduling
@EnableAsync
@Slf4j
public class Zero {
    @Resource
    UserMapper userMapper;
    @Async
    @Scheduled(fixedDelay = 1000*60*60*24)
    public void reAdd(){
        log.info("定时开启");
        userMapper.updateAll();
        log.info("票数恢复");
        System.out.println("恢复票数");
    }
}
