package com.zys.elec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zys.elec.entity.User;

@Mapper
public interface UserMapper {
    int insert(User user);
    boolean deleteById(Long id);
    int update(User user);
    User selectById(Long id);
    List<User> selectAll();
     // 根据用户名查询用户
    User selectByUsername(@Param("username") String username);
}