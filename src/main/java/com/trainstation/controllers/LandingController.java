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
	public ModelAndView getHomePage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("landing");
	}

	@GetMapping("/tablePage")
	public ModelAndView getTablePage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("tablepage");
	}

	@GetMapping("/detailPage")
	public ModelAndView getDetailPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("detailpage");
	}
	
	@GetMapping("/stations")
	public @ResponseBody Map<String, Object> getStationList(HttpServletRequest request,
			@RequestParam Map<String, Object> params) {
		int startIndex = Integer.parseInt(params.get("start").toString());
		int pageSize = Integer.parseInt(params.get("length").toString());
		String startDate = params.get("startDate").toString();
		String endDate = params.get("endDate").toString();
		return trainStationService.getStationList(startIndex, pageSize,startDate,endDate);
	}

	@GetMapping("/trainStationDetail")
	public @ResponseBody Map<String, Object> getDetailPage(HttpServletRequest request,
			@RequestParam Map<String, Object> params) throws Exception {
		Map<String, Object> data = new HashMap<>();
		data.put("data", trainStationService.getStationDetail(params.get("stationName").toString()));
		return data;
	}

}
