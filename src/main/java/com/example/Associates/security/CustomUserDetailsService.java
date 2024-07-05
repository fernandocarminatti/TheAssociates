package com.example.Associates.security;

import com.example.Associates.model.ApplicationUser;
import com.example.Associates.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    ApplicationUserRepository applicationUserRepository;

    CustomUserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(applicationUser.getEmail(), applicationUser.getPassword(), new ArrayList<>());
    }
}
