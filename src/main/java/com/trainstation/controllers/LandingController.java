package com.trainstation.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public @ResponseBody Map<String, Object> getStationList(HttpServletRequest request, @RequestParam Map<String,Object> params) throws IOException {
		System.out.println(params.toString());
		Map<String,Object> data = new HashMap<>();
		
		int pageNumber = Integer.parseInt(params.get("draw").toString());
		int start = Integer.parseInt(params.get("start").toString());
		int pageSize = Integer.parseInt(params.get("length").toString());
		
		//data.put("draw", 1);
		data.put("recordsTotal",trainStationService.trainStationDetails.size());
		data.put("recordsFiltered",trainStationService.trainStationDetails.size());
		data.put("data",trainStationService.getStationList(pageSize,pageNumber));
		return data;
	}
	
	@GetMapping("/tablePage")
	public ModelAndView getTablePage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return new ModelAndView("tablepage");
	}
	
	@GetMapping("/detailPage")
	public ModelAndView getDetailPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return new ModelAndView("detailpage");
	}

	
}
