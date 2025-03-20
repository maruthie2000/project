package com.nit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.PlanCategory;
import com.nit.entity.TravelPlan;
import com.nit.repositroy.IPlanCategoryRepository;
import com.nit.repositroy.ITravelPlanRepository;

@Service
public class TravelPlanServiceImpl implements ITravelPlanService {

	@Autowired
	private ITravelPlanRepository travelPlanRepository;

	@Autowired
	private IPlanCategoryRepository planCategoryRepository;

	@Override
	public String registerTravelPlan(TravelPlan plan) {
		// save the object
		TravelPlan saved = travelPlanRepository.save(plan);
		return saved.getPlanId() != null ? "Travel plan is saved with id value :: " + saved.getPlanId()
				: "Problem in saving Tour Plan";

	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		// get All TravelPlan Categories
		List<PlanCategory> list = planCategoryRepository.findAll();
		Map<Integer, String> categoriesMap = new HashMap<Integer, String>();
		list.forEach(category -> {
			categoriesMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {

		return travelPlanRepository.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planid) {
		return travelPlanRepository
				.findById(planid)
				.orElseThrow(() -> new IllegalArgumentException("Travel Plan is not found.."));

	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		Optional<TravelPlan> opt = travelPlanRepository.findById(plan.getPlanId());
		if (opt.isPresent()) {
			travelPlanRepository.save(plan); // update the object
			return plan.getPlanId() + "Travel plan is update";
		} else
			return plan.getPlanId() + "Travel plan is not found";
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt = travelPlanRepository.findById(planId);
		if (opt.isPresent()) {
			travelPlanRepository.deleteById(planId);
			return planId + "Travel plan is deleted";

		} else {
			return planId + "Travel plan is not found";
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		Optional<TravelPlan> opt = travelPlanRepository.findById(planId);
		if (opt.isPresent()) {
			TravelPlan plan = opt.get();
			plan.setActiveSW(status);
			travelPlanRepository.save(plan);
			return planId + "Travel plan status is changed..";
		} else
			return planId + "Travel plan is not found..";
	}

}
