package com.nice.main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nice.data.repo.UserRepository;
import com.nice.entities.Role;
import com.nice.entities.User;
import com.nice.security.config.CustomUserDetails;
import com.nice.service.processor.UserService;


@SpringBootApplication
public class App {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
		if (repository.count()==0)
			service.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);;
	}
	
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
}
