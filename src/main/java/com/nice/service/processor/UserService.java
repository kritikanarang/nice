package com.nice.service.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nice.data.repo.UserRepository;
import com.nice.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(User user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
    }

}