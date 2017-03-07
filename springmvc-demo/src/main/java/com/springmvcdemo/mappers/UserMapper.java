package com.springmvcdemo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springmvcdemo.entities.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int getCount();

	List<User> getList(@Param("start")int start,@Param("limit")int limit);
}