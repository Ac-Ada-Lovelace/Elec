package com.zys.elec.controller;

import com.zys.elec.entity.Follow;
import com.zys.elec.service.FollowService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Resource
    private FollowService followService;

    @PostMapping
    public int createFollow(@RequestBody Follow follow) {
        return followService.createFollow(follow);
    }

    @DeleteMapping("/{id}")
    public int deleteFollow(@PathVariable Long id) {
        return followService.deleteFollow(id);
    }

    @PutMapping("/{id}")
    public int updateFollow(@PathVariable Long id, @RequestBody Follow follow) {
        follow.setId(id);
        return followService.updateFollow(follow);
    }

    @GetMapping("/{id}")
    public Follow getFollowById(@PathVariable Long id) {
        return followService.getFollowById(id);
    }

    @GetMapping
    public List<Follow> getAllFollows() {
        return followService.getAllFollows();
    }
}