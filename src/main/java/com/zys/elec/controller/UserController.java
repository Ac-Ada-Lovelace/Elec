package com.zys.elec.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.User;
import com.zys.elec.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 创建用户
     */
    @PostMapping
    public ResponseResult createUser(@RequestBody User user) {
        boolean success = userService.save(user);
        return success ? ResponseResult.success("用户创建成功") : ResponseResult.error("用户创建失败");
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public ResponseResult getUserById(@PathVariable Long id) {
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        return user.map(ResponseResult::success)
                .orElse(ResponseResult.error("用户不存在"));
    }



    /**
     * 更新用户信息
     */
    @PutMapping("/{id}")
    public ResponseResult updateUser(@PathVariable Long id, @RequestBody User user) {
        if (id < 0) {
            return ResponseResult.error("用户ID不合法");
        }
        boolean success = userService.updateUser(user);
        return success ? ResponseResult.success("用户更新成功") : ResponseResult.error("用户更新失败");
    }

    /**
     * 逻辑删除用户
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable Long id) {

        boolean success = userService.deleteUser(id);
        return success ? ResponseResult.success("用户删除成功") : ResponseResult.error("用户删除失败");
    }
}
