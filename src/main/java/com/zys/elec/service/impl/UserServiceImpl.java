package com.zys.elec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zys.elec.common.ServiceResult;
import com.zys.elec.entity.User;
import com.zys.elec.mapper.UserMapper;
import com.zys.elec.service.UserService;

// TODO: ADD DATA VALIDATION
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ServiceResult<Boolean> createUser(User user) {

        if (userMapper.selectByUsername(user.getUsername()) != null) {
            return ServiceResult.failure("用户名已存在");
        } else {
            boolean success = userMapper.insert(user) > 0;
            return success ? ServiceResult.success(true) : ServiceResult.failure("创建失败");
        }

    }

    @Override
    public ServiceResult<Boolean> deleteUser(Long id) {
        boolean success = userMapper.deleteById(id);
        return success ? ServiceResult.success(true) : ServiceResult.failure("删除失败");
    }

    @Override
    public ServiceResult<Boolean> updateUser(User user) {
        boolean success = userMapper.update(user) > 0;
        return success ? ServiceResult.success(true) : ServiceResult.failure("更新失败");
    }

    @Override
    public ServiceResult<User> getUserById(Long id) {
        User user = userMapper.selectById(id);
        return user != null ? ServiceResult.success(user) : ServiceResult.failure("用户不存在");
    }


    @Override
    public ServiceResult<List<User>> getAllUsers() {
        List<User> users = userMapper.selectAll();
        return ServiceResult.success(users);
    }


    private boolean save(User user) {
        // implement save user
        if (user.getId() == null) {
            return userMapper.insert(user) > 0;
        } else {
            return userMapper.update(user) > 0;
        }

    }

    // @Override
    // public Page<User> getUsers(int page, int size) {
    // Page<User> userPage = new Page<Boolean>(page, size);
    // return userMapper.selectPage(userPage);
    // }

}
