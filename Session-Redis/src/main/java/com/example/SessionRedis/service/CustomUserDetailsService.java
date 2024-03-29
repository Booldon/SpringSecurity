package com.example.SessionRedis.service;

import com.example.SessionRedis.dto.CustomUserDetails;
import com.example.SessionRedis.entity.UserEntity;
import com.example.SessionRedis.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity findUser = userRepository.findByUsername(username);

        if(findUser != null) {

            return new CustomUserDetails(findUser);
        }

        return null;
    }
}
