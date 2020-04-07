package com.trainstation.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.trainstation.services.TrainStationService;

@Controller
public class LandingController {

	public static final Logger logger = LogManager.getLogger(LandingController.class);

	@Autowired(required = true)
	TrainStationService trainStationService;

	@GetMapping("/")
	public ModelAndView getHomePage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/landing page requested");
		return new ModelAndView("landing");
	}

	@GetMapping("/tablePage")
	public ModelAndView getTablePage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/tablepage  requested");
		return new ModelAndView("tablepage");
	}

	@GetMapping("/detailPage")
	public ModelAndView getDetailPage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("/detailpage requested");
		return new ModelAndView("detailpage");
	}

	@GetMapping("/stations")
	public @ResponseBody Map<String, Object> getStationList(HttpServletRequest request,
			@RequestParam Map<String, Object> params) {
		logger.info("station list requsted");
		Map<String, Object> data = new HashMap<>();
		try {
			int startIndex = Integer.parseInt(params.get("start").toString());
			int pageSize = Integer.parseInt(params.get("length").toString());
			String startDate = params.get("startDate").toString();
			String endDate = params.get("endDate").toString();
			data.putAll(trainStationService.getStationList(startIndex, pageSize, startDate, endDate));
			data.put("success", true);
			data.put("message", "train stations list received successfully");
		} catch (Exception ex) {
			data.put("success", false);
			data.put("message", "error while getting train stations");
			logger.error("error while getting train stations", ex);
		}
		return data;
	}

	@GetMapping("/trainStationDetail")
	public @ResponseBody Map<String, Object> getDetailPage(HttpServletRequest request,
			@RequestParam Map<String, Object> params){
		Map<String, Object> data = new HashMap<>();
		logger.info("train station detail for {} requested.", params.get("stationName").toString());
		try {
			data.put("data", trainStationService.getStationDetail(params.get("stationName").toString()));
			data.put("success", true);
			data.put("message", "train station detail received successfully");
		} catch (Exception ex) {
			data.put("success", false);
			data.put("message", "error while getting train station detail");
			logger.error("error while getting train station detail", ex);
		}
		return data;
	}

}
