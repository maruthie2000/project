package com.nit.service;

import java.util.List;
import java.util.Map;

import com.nit.entity.TravelPlan;

public interface ITravelPlanService {
	public String registerTravelPlan(TravelPlan plan); // save operation

	public Map<Integer, String> getTravelPlanCategories(); // select operation

	public List<TravelPlan> showAllTravelPlans(); // for select operation

	public TravelPlan showTravelPlanById(Integer planid); // for edit operation from launch(to show existing recored for
															// editing)

	public String updateTravelPlan(TravelPlan plan); // for edit operation form submission

	public String deleteTravelPlan(Integer planId); // for delete operation(hard deletion)

	public String changeTravelPlanStatus(Integer planId, String status); // for soft deletion activity

}
