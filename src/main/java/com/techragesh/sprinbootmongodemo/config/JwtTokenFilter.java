package com.techragesh.sprinbootmongodemo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenConfig jwtTokenConfig;

    public JwtTokenFilter(JwtTokenConfig jwtTokenConfig) {
        this.jwtTokenConfig = jwtTokenConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenConfig.resolveToken((HttpServletRequest) servletRequest);
        if (token != null && jwtTokenConfig.validateToken(token)) {
            Authentication auth = token != null ? jwtTokenConfig.getAuthentication(token) : null;
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
