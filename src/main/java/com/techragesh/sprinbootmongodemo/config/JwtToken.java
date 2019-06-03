package com.techragesh.sprinbootmongodemo.config;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtToken extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenConfig jwtTokenConfig;

    public JwtToken(JwtTokenConfig jwtTokenConfig) {
        this.jwtTokenConfig = jwtTokenConfig;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenConfig);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
