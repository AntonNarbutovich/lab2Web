package com.company.myapp.service;

import com.company.myapp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUser(login);
        return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getEmp().getRole().name()).build();
    }
}
