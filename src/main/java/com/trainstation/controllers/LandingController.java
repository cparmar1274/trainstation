package com.trainstation.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.trainstation.pojos.TrainStation;
import com.trainstation.services.TrainStationService;

@Controller
public class LandingController {

	@Autowired(required = true)
	TrainStationService trainStationService;
	
	@GetMapping("/")
	public ModelAndView getHomePage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		trainStationService.readCSVFileToUpdateStationList();
		return new ModelAndView("landing");
	}
	
	@GetMapping("/stations")
	public @ResponseBody List<TrainStation> getStationList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return trainStationService.getStationList(10, 1, 1);
	}

	
}
