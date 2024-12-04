package com.zys.elec.service;

import com.zys.elec.entity.Post;
import java.util.List;

public interface PostService {
    int createPost(Post post);
    int deletePost(Long id);
    int updatePost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
}