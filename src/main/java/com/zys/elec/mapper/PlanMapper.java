package com.zys.elec.mapper;

import com.zys.elec.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PlanMapper {
    int insert(Plan plan);
    int deleteById(Long id);
    int update(Plan plan);
    Plan selectById(Long id);
    List<Plan> selectAll();
}