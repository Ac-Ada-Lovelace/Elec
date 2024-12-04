package com.zys.elec.service.impl;

import com.zys.elec.service.DataService;
import com.zys.elec.mapper.DataMapper;
import com.zys.elec.entity.Data;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource
    private DataMapper dataMapper;

    @Override
    public int createData(Data data) {
        return dataMapper.insert(data);
    }

    @Override
    public int deleteData(Long id) {
        return dataMapper.deleteById(id);
    }

    @Override
    public int updateData(Data data) {
        return dataMapper.update(data);
    }

    @Override
    public Data getDataById(Long id) {
        return dataMapper.selectById(id);
    }

    @Override
    public List<Data> getAllData() {
        return dataMapper.selectAll();
    }
}