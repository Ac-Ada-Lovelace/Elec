package com.zys.elec.service;

import com.zys.elec.entity.Data;
import java.util.List;

public interface DataService {
    int createData(Data data);
    int deleteData(Long id);
    int updateData(Data data);
    Data getDataById(Long id);
    List<Data> getAllData();
}