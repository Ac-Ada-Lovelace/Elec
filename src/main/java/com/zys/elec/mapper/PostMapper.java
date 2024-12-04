package com.zys.elec.mapper;

import com.zys.elec.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    int insert(Post post);
    int deleteById(Long id);
    int update(Post post);
    Post selectById(Long id);
    List<Post> selectAll();
}