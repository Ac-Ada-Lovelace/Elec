package com.zys.elec.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import com.zys.elec.entity.User;

@Mapper
public interface UserMapper {
    int insert(User user);
    boolean deleteById(Long id);
    int update(User user);
    User selectById(Long id);
    List<User> selectAll();

}