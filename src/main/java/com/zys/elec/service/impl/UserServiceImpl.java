package com.zys.elec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zys.elec.entity.User;
import com.zys.elec.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.elec.service.UserService;


// TODO: ADD DATA VALIDATION
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean createUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id);
    }


    @Override
    public boolean updateUser(User user) {
        if (user == null || user.getId() == null) {
            return false;
        }
        int result = userMapper.update(user);
        return result > 0;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public boolean save(User user) {
        // implement save user
        if (user.getId() == null) {
            return userMapper.insert(user) > 0;
        } else {
            return userMapper.update(user) > 0;
        }

    }



//    @Override
//    public Page<User> getUsers(int page, int size) {
//        Page<User> userPage = new Page<>(page, size);
//        return userMapper.selectPage(userPage);
//    }

}
