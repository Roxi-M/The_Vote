package com.roxi.vote.mapper;

import com.roxi.vote.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Roxi酱
 */
@Mapper
public interface UserMapper {
    /**
     * insert 用户
     * @param user
     */
    @Insert("insert into user(id,openId,ticket) values(#{id},#{openId},#{ticket})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(User user);

    /**
     * 通过OpenId 找这个人 如果没有就给他insert
     * @param user
     * @return
     */
    @Select("select * from user where openId=#{openId}")
    User select(User user);

    /**
     * 更改票数
     * @param user
     */
    @Update("update user set ticket=ticket-1 where openId=#{openId}")
    void update(User user);

    /**
     * 恢复票数
     */
    @Update("update user set ticket=5")
    void updateAll();
}
