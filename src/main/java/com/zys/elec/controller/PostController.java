package com.zys.elec.controller;

import com.zys.elec.entity.Post;
import com.zys.elec.service.PostService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Resource
    private PostService postService;

    @PostMapping
    public int createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public int updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postService.updatePost(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}