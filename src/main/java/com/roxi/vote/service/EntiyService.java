package com.roxi.vote.service;

import com.roxi.vote.bean.Entiy;
import com.roxi.vote.mapper.EntiyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roxi酱
 */
@Service
public class EntiyService {
    @Autowired
    private EntiyMapper entiyMapper;

    public Entiy select(int id){
        Entiy entiy=new Entiy();
        entiy.setId(id);
        entiyMapper.update(entiy);
      //  entiy=entiyMapper.select(id);
        return entiy;
    }
}
