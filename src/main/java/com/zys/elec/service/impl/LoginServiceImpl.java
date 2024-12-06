package com.zys.elec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zys.elec.common.ServiceResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.LoginService;
import com.zys.elec.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    UserService userService;

    @Override
    public ServiceResult<Boolean> login(User user) {
        var result = userService.getUserByUser(user).isSuccess();
        if (result) {
            return ServiceResult.success(true);
        } else {
            return ServiceResult.failure("用户名或密码错误");
        }
    }

}
