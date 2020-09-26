package com.amirghaffari.SpringSecurity;

import com.amirghaffari.SpringSecurity.model.Role;
import com.amirghaffari.SpringSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        org.springframework.security.core.userdetails.User.UserBuilder users =
                org.springframework.security.core.userdetails.User.builder().passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode);

        List<String> list=user.getRoles().stream().map(
                Role::getName
        ).collect(Collectors.toList());

        return users.username(user.getUsername())
                .password(user.getPassword())
                .roles(list.toArray(new String[list.size()])).build();
    }
}