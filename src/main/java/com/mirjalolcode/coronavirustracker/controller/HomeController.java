package com.mirjalolcode.coronavirustracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mirjalolcode.coronavirustracker.service.CoronavirusDataService;

@Controller
public class HomeController {

	@Autowired
	CoronavirusDataService coronavirusDataService;
	
	@GetMapping("/")
	public String home(Model theModel) {
		
		theModel.addAttribute("locationStats", coronavirusDataService.getAllStats());
		return "home";
	}
}
