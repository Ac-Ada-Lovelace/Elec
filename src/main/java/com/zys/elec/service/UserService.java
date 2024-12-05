package com.zys.elec.service;


import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.elec.entity.User;

public interface UserService {
    boolean createUser(User user);
    boolean deleteUser(Long id);
    boolean updateUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    boolean save(User user);

}