package com.zys.elec.service;


import java.util.List;

import com.zys.elec.entity.User;

public interface UserService {
    int createUser(User user);
    int deleteUser(Long id);
    int updateUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}