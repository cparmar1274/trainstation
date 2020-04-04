package com.trainstation.configuration;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TrainStationUserDetails implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8, new SecureRandom());
		List<? extends GrantedAuthority> authorities = new ArrayList<>();
		return new TrainStationUser(passwordEncoder.encode("admin"), "admin", authorities, true, true, true, true,
				"Train Station User");
	}

}
