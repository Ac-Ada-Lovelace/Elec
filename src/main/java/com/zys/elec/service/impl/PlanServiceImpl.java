package com.zys.elec.service.impl;

import com.zys.elec.service.PlanService;
import com.zys.elec.mapper.PlanMapper;
import com.zys.elec.entity.Plan;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;

    @Override
    public int createPlan(Plan plan) {
        return planMapper.insert(plan);
    }

    @Override
    public int deletePlan(Long id) {
        return planMapper.deleteById(id);
    }

    @Override
    public int updatePlan(Plan plan) {
        return planMapper.update(plan);
    }

    @Override
    public Plan getPlanById(Long id) {
        return planMapper.selectById(id);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planMapper.selectAll();
    }
}