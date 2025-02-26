package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.TravelPlan;
import com.nit.service.ITravelPlanService;

@RestController
@RequestMapping("/travelplan/api")
public class TravelPlanOperationController {

	@Autowired
	private ITravelPlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<?> showTravelPlanCategories() {
		// invoke service class methods
		try {
			Map<Integer, String> mapCategories = planService.getTravelPlanCategories();
			return new ResponseEntity<Map<Integer, String>>(mapCategories, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/register")
	public ResponseEntity<String> saveTourPlan(@RequestBody TravelPlan plan) {
		// use service
		try {
			String msg = planService.registerTravelPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTravelPlanes() {
		// use service
		try {
			List<TravelPlan> list = planService.showAllTravelPlans();
			return new ResponseEntity<List<TravelPlan>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/find/{planId}")
	public ResponseEntity<?> getTravelPlanbyId(@PathVariable Integer planId) {
		// use service
		try {
			TravelPlan plan = planService.showTravelPlanById(planId);
			return new ResponseEntity<TravelPlan>(plan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan plan) {
		// use service
		try {
			String msg = planService.updateTravelPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<?> removeTravelPlanById(@PathVariable Integer planId) {
		try {
			String msg = planService.deleteTravelPlan(planId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeTravelPlanStatus(@PathVariable Integer planId, @PathVariable String status) {
		// use service
		try {
			String msg = planService.changeTravelPlanStatus(planId, status);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
