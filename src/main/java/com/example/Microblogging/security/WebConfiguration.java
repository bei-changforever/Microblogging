package com.example.Microblogging.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}

