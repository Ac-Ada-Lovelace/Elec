package com.zys.elec.service;


import java.util.List;

import com.zys.elec.common.ServiceResult;
import com.zys.elec.entity.User;

public interface UserService {
    ServiceResult<Boolean> createUser(User user);
    ServiceResult<Boolean> deleteUser(Long id);
    ServiceResult<Boolean> updateUser(User user);
    ServiceResult<User> getUserById(Long id);
    ServiceResult<List<User>> getAllUsers();
    ServiceResult<Boolean> getUserByUser(User user);
}