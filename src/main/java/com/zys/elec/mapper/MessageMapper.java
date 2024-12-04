package com.zys.elec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zys.elec.entity.Message;

@Mapper
public interface MessageMapper {
    int insert(Message message);
    int deleteById(Long id);
    int update(Message message);
    Message selectById(Long id);
    List<Message> selectAll();
}