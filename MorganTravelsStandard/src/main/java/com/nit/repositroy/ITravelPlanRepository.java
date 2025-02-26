package com.nit.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
