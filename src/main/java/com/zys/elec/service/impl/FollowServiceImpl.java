package com.zys.elec.service.impl;

import com.zys.elec.service.FollowService;
import com.zys.elec.mapper.FollowMapper;
import com.zys.elec.entity.Follow;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Resource
    private FollowMapper followMapper;

    @Override
    public int createFollow(Follow follow) {
        return followMapper.insert(follow);
    }

    @Override
    public int deleteFollow(Long id) {
        return followMapper.deleteById(id);
    }

    @Override
    public int updateFollow(Follow follow) {
        return followMapper.update(follow);
    }

    @Override
    public Follow getFollowById(Long id) {
        return followMapper.selectById(id);
    }

    @Override
    public List<Follow> getAllFollows() {
        return followMapper.selectAll();
    }
}