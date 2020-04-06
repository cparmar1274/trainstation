package com.trainstation.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.error.ErrorController;

import com.trainstation.controllers.LandingController;
import com.trainstation.services.TrainStationService;

@SpringBootTest
class TrainStationApplicationTests {

	@Autowired
	private LandingController ladingController;
	
	@Autowired
	private ErrorController errorController;

	@Autowired
	private TrainStationService trainStationService;
	
	@DisplayName("Check context loading for LandingController,ErrorController and TrainStationService class(s)")
	@Test
	public void contexLoads() throws Exception {
		assertThat(ladingController).isNotNull();
		assertThat(errorController).isNotNull();
		assertThat(trainStationService).isNotNull();
	}

}
