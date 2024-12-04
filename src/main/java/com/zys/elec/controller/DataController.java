package com.zys.elec.controller;

import com.zys.elec.entity.Data;
import com.zys.elec.service.DataService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

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