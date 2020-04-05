
package com.trainstation.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorHandlerController implements ErrorController {

	Logger logger = LogManager.getLogger(ErrorHandlerController.class);
	
	@GetMapping("/error")
	public ModelAndView getError(HttpServletRequest request, HttpServletResponse response) {
		logger.error("error while processing. {}",request.getRequestURI());
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorCode", response.getStatus());
		model.addObject("errorMessage", "Something went wrong.Please try again");
		return model;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
