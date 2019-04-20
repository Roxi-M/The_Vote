package com.roxi.vote.mapper;

import com.roxi.vote.bean.Votes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Roxi酱
 */
@Mapper
public interface VotesMapper {
    /**
     * 添加投票数据
     * @param votes
     */
    @Insert("insert into votes(id,uid,entiyId,timestamp) values(#{id},#{uid},#{entiyId},#{timestamp})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void insert(Votes votes);
}
