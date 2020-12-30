package com.mirjalolcode.coronavirustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mirjalolcode.coronavirustracker.model.LocationStats;
import com.mirjalolcode.coronavirustracker.service.CoronavirusDataService;

@Controller
public class HomeController {

	@Autowired
	CoronavirusDataService coronavirusDataService;
	
	@GetMapping("/")
	public String home(Model theModel) {
		
		List<LocationStats> allStats=coronavirusDataService.getAllStats();
		int totalReportedCases=allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		theModel.addAttribute("locationStats", allStats);
		theModel.addAttribute("totalReportedCases", totalReportedCases);
		
		return "home";
	}
}
