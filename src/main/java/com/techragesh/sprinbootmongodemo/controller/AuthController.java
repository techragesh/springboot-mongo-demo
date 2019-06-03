package com.techragesh.sprinbootmongodemo.controller;

import com.techragesh.sprinbootmongodemo.config.JwtTokenConfig;
import com.techragesh.sprinbootmongodemo.model.User;
import com.techragesh.sprinbootmongodemo.repository.UserDao;
import com.techragesh.sprinbootmongodemo.service.impl.CustomUserDetailServiceImpl;
import com.techragesh.springbootmongodemo.model.generated.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenConfig jwtTokenConfig;

    @Autowired
    UserDao users;

    @Autowired
    private CustomUserDetailServiceImpl userService;


    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login) {
        try {
            String username = login.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, login.getPassword()));
            String token = jwtTokenConfig.createToken(username, this.users.findByUsername(username).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            throw new BadCredentialsException("Login with username: " + user.getUsername() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }

}
