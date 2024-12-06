package com.zys.elec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zys.elec.common.ServiceResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.SignUpSerivce;
import com.zys.elec.service.UserService;

@Service
public class SignUpServiceImpl implements SignUpSerivce {
    @Autowired
    UserService userService;

    @Override
    public ServiceResult<String> signUp(User user) {
        var exists = userService.getUserByUser(user).isSuccess();
        if (exists) {
            return ServiceResult.failure("用户名已存在");
        }

        var success = userService.createUser(user).isSuccess();
        return success ? ServiceResult.success("注册成功") : ServiceResult.failure("注册失败");
    }

}
