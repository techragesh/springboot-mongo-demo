package com.techragesh.sprinbootmongodemo.service.impl;

import com.techragesh.sprinbootmongodemo.model.Role;
import com.techragesh.sprinbootmongodemo.model.User;
import com.techragesh.sprinbootmongodemo.repository.RoleDao;
import com.techragesh.sprinbootmongodemo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user !=  null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return formUserForAuthentication(user,authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private UserDetails formUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> roles) {
        Set<GrantedAuthority> roleSet = new HashSet<>();
        roles.forEach((role) -> {
            roleSet.add(new SimpleGrantedAuthority(role.getRole()));
        });
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roleSet);
        return grantedAuthorities;
    }


    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role role = roleDao.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userDao.save(user);
    }
}
