package com.zys.elec.service.impl;

import com.zys.elec.service.PostService;
import com.zys.elec.mapper.PostMapper;
import com.zys.elec.entity.Post;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public int createPost(Post post) {
        return postMapper.insert(post);
    }

    @Override
    public int deletePost(Long id) {
        return postMapper.deleteById(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.update(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postMapper.selectById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.selectAll();
    }
}