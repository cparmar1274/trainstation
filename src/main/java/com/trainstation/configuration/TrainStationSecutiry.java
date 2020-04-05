package com.trainstation.configuration;

import java.io.IOException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.trainstation.services.TrainStationService;

@Configuration
@EnableWebSecurity
public class TrainStationSecutiry extends WebSecurityConfigurerAdapter {

	@Autowired
	TrainStationUserDetails trainStationUserDetails;

	@Autowired
	TrainStationService trainStationService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(trainStationUserDetails)
				.passwordEncoder(new BCryptPasswordEncoder(8, new SecureRandom()));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").authenticated().and().formLogin().and().rememberMe();

		// read data from csv file
		try {
			trainStationService.readCSVFileToUpdateStationList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
