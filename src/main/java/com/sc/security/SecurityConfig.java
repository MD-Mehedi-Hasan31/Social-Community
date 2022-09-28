package com.sc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {

        managerBuilder.inMemoryAuthentication()
                .withUser("mehedi")
                .password("{noop}12345")
                .roles("admin");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.
                authorizeHttpRequests((request)-> request.
                        anyRequest().
                        authenticated());
        httpSecurity.httpBasic(withDefaults());

        return httpSecurity.build();
    }
}
