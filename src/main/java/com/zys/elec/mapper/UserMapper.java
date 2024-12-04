package com.zys.elec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zys.elec.entity.User;

@Mapper
public interface UserMapper {
    int insert(User user);
    int deleteById(Long id);
    int update(User user);
    User selectById(Long id);
    List<User> selectAll();
}