package com.zys.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.JWTAuthService;
import com.zys.elec.service.LoginService;

import io.micrometer.common.lang.NonNull;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JWTAuthService jwtAuthService;

    // example of a POST request
    // url: http://localhost:8080/login
    // headers: { "Content-Type": "application/json" }
    // body {{""username"": ""admin"", ""password"": ""admin""}, ""captcha"": ""123456""}
    @PostMapping("/")
    public ResponseResult<String> login(@RequestBody @NonNull User user, @NonNull String captcha) {
        var res = loginService.login(user);

        if (!res.isSuccess()) {
            return ResponseResult.failure(res.getMessage());
        }
        String token = jwtAuthService.generateToken(user.getUsername(), captcha); // Generate JWT
        return ResponseResult.success(token);
    }
}