package com.example.logindemo.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private static final Map<String, UserDetails> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "{noop}admin123",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))));

        users.put("user", new User("user", "{noop}user123",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));

        users.put("elon", new User("elon", "{noop}musk123",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
