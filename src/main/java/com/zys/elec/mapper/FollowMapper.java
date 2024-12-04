package com.zys.elec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zys.elec.entity.Follow;

@Mapper
public interface FollowMapper {
    int insert(Follow follow);
    int deleteById(Long id);
    int update(Follow follow);
    Follow selectById(Long id);
    List<Follow> selectAll();
}