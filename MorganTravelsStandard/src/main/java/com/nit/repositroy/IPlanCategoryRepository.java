package com.nit.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.PlanCategory;

public interface IPlanCategoryRepository  extends JpaRepository<PlanCategory, Integer>{

}
