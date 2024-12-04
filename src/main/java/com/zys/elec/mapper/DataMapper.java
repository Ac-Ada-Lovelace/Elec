package com.zys.elec.mapper;

import com.zys.elec.entity.Data;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DataMapper {
    int insert(Data data);
    int deleteById(Long id);
    int update(Data data);
    Data selectById(Long id);
    List<Data> selectAll();
}