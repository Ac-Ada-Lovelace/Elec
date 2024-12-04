package com.zys.elec.service;

import com.zys.elec.entity.Plan;
import java.util.List;

public interface PlanService {
    int createPlan(Plan plan);
    int deletePlan(Long id);
    int updatePlan(Plan plan);
    Plan getPlanById(Long id);
    List<Plan> getAllPlans();
}