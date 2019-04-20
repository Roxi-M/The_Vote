package com.roxi.vote.mapper;

import com.roxi.vote.bean.Entiy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Roxi酱
 */
public interface EntiyMapper {

    /**
     * insert entiy
     * @param entiy
     */
    @Insert("insert into entiy(id,name) values(#{id},#{name})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(Entiy entiy);

    /**
     * 更改 投票的数据
     * @param entiy
     */
    @Update("update entiy set counts=counts+1 where id=#{id}")
    void update(Entiy entiy);

    /**
     * 找entiy
     * @param name
     * @return
     */
    @Select("select * from entiy where name=#{name}")
    Entiy select(String name);
}