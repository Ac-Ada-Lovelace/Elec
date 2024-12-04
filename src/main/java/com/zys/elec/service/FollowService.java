package com.zys.elec.service;

import java.util.List;

import com.zys.elec.entity.Follow;

public interface FollowService {
    int createFollow(Follow follow);
    int deleteFollow(Long id);
    int updateFollow(Follow follow);
    Follow getFollowById(Long id);
    List<Follow> getAllFollows();
}