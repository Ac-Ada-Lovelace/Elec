package com.zys.elec.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zys.elec.common.ResponseResult;
import com.zys.elec.entity.Data;
import com.zys.elec.service.DataService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private DataService dataService;

    @PostMapping
    public ResponseResult<String> createData(@RequestBody @Valid Data data) {
        int result = dataService.createData(data);
        return result > 0 ? ResponseResult.success("数据创建成功") : ResponseResult.failure("数据创建失败");
    }
    @DeleteMapping("/{id}")
    public ResponseResult<String> deleteData(@PathVariable @NotNull Long id) {
        int result = dataService.deleteData(id);
        return result > 0 ? ResponseResult.success("数据删除成功") : ResponseResult.failure("数据删除失败");
    }

    @PutMapping("/{id}")
    public int updateData(@PathVariable Long id, @RequestBody Data data) {
        data.setId(id);
        return dataService.updateData(data);
    }

    @GetMapping("/{id}")
    public Data getDataById(@PathVariable Long id) {
        return dataService.getDataById(id);
    }

    @GetMapping
    public ResponseResult<List<Data>> getAllData() {
        List<Data> dataList = dataService.getAllData();
        return ResponseResult.success(dataList);
    }

    
}