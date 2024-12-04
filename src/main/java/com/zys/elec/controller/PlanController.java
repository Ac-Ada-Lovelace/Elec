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

import com.zys.elec.entity.Plan;
import com.zys.elec.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Resource
    private PlanService planService;

    @PostMapping
    public int createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @DeleteMapping("/{id}")
    public int deletePlan(@PathVariable Long id) {
        return planService.deletePlan(id);
    }

    @PutMapping("/{id}")
    public int updatePlan(@PathVariable Long id, @RequestBody Plan plan) {
        plan.setId(id);
        return planService.updatePlan(plan);
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }
}
