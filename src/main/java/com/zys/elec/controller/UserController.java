package com.zys.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.UserService;

import io.micrometer.common.lang.NonNull;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 创建用户
     * example request: POST /users
     */
    @PostMapping
    public ResponseResult<String> createUser(@RequestBody @Valid User user) {
        var res = userService.createUser(user);
        return res.isSuccess() ? ResponseResult.success("用户创建成功") : ResponseResult.failure(res.getMessage());
    }

    /**
     * 根据ID查询用户
     * example request: GET /users/1
     */
    @GetMapping("/{id}")
    public ResponseResult<User> getUserById(@PathVariable @Valid Long id) {
        var user = userService.getUserById(id);
        return user.isSuccess() ? ResponseResult.success(user.getData()) : ResponseResult.error(user.getMessage());
    }

    /**
     * 更新用户信息
     * example request: PUT /users/1
     */
    @PutMapping("/{id}")
    public ResponseResult<String> updateUser(@PathVariable @NonNull Long id, @RequestBody @Valid User user) {
        user.setId(id);
        var res = userService.updateUser(user);
        return res.isSuccess() ? ResponseResult.success("用户更新成功") : ResponseResult.error(res.getMessage());
    }

    /**
     * 逻辑删除用户
     * example request: DELETE /users/1
     */
    @DeleteMapping("/{id}")
    public ResponseResult<String> deleteUser(@PathVariable @NonNull @Valid Long id) {
        var res = userService.deleteUser(id);
        return res.isSuccess() ? ResponseResult.success("用户删除成功") : ResponseResult.error(res.getMessage());
    }
}
