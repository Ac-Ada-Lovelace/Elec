package com.zys.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.SignUpSerivce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    SignUpSerivce signUpService;
    
    // example body: {"username":"test","password":"test"}
    @PostMapping
    public ResponseResult<String> signUp(@RequestBody User user) {
        var res = signUpService.signUp(user);
        return res.isSuccess() ? ResponseResult.success(res.getData()) : ResponseResult.failure(res.getMessage());
    }
    
    
}
