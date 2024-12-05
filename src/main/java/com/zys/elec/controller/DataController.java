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

import com.zys.elec.entity.Data;
import com.zys.elec.service.DataService;

@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private DataService dataService;

    @PostMapping
    public int createData(@RequestBody Data data) {
        return dataService.createData(data);
    }

    @DeleteMapping("/{id}")
    public int deleteData(@PathVariable Long id) {
        return dataService.deleteData(id);
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
    public List<Data> getAllData() {
        return dataService.getAllData();
    }
}