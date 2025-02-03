package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellComeController {
	//public rest service without having any security...
	
	@GetMapping("/wellcome")
	public String sayWellCome() {
		return "Well come to spring application without security...";
	}
}
