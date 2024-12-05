package com.zys.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.JWTAuthService;
import com.zys.elec.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JWTAuthService jwtAuthService;

    public ResponseResult<String> login(@RequestBody @Valid User user, String captcha) {
        var res = loginService.login(user);

        if (!res.isSuccess()) {
            return ResponseResult.failure(res.getMessage());
        }
        String token = jwtAuthService.generateToken(user.getUsername(), captcha); // Generate JWT
        return ResponseResult.success(token);

    }
}