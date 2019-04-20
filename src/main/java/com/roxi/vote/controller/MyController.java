package com.roxi.vote.controller;

import com.roxi.vote.bean.Entiy;
import com.roxi.vote.bean.User;
import com.roxi.vote.service.EntiyService;
import com.roxi.vote.service.UserService;
import com.roxi.vote.service.VotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.acl.Owner;


/**
 * @author Roxi酱
 */
@RestController
@RequestMapping("/vote")
public class MyController {
    @Autowired
    VotesService votesService;

    @PostMapping("/yours/voting")
    public String vote(@RequestParam("entiy") String name, HttpSession session){
        String openId= (String) session.getAttribute("user");
        User user=new User();
        user.setOpenId(openId);
        Entiy entiy=new Entiy();
        entiy.setName(name);
        boolean flag=votesService.add(entiy,user);
        if(flag) {
            return "投票成功";
        }else {
            return "票数不足";
        }
    }
}
