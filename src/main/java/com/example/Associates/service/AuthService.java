package com.example.Associates.service;

import com.example.Associates.dtos.AuthenticationDto;
import com.example.Associates.dtos.AuthenticationResponseDto;
import com.example.Associates.dtos.RegisterDto;
import com.example.Associates.dtos.RegisterResponseDto;
import com.example.Associates.model.ApplicationUser;
import com.example.Associates.repository.ApplicationUserRepository;
import com.example.Associates.security.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    ApplicationUserRepository applicationUserRepository;
    PasswordEncoder passwordEncoder;
    TokenService tokenService;

    public AuthService(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public AuthenticationResponseDto login(AuthenticationDto authenticationDto) {
        ApplicationUser user = applicationUserRepository.findByEmail(authenticationDto.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(authenticationDto.password(), user.getPassword())) {
            String generatedToken = tokenService.generateToken(user);
            return new AuthenticationResponseDto(user.getEmail(), generatedToken);
        }
        return null;
    }

    public RegisterResponseDto register(RegisterDto registerDto) {
        boolean found = applicationUserRepository.findByEmail(registerDto.email()).isPresent();
        if (found) {
            return null;
        }

        ApplicationUser user = new ApplicationUser.ApplicationUserBuilder()
                .setUsername(registerDto.username())
                .setEmail(registerDto.email())
                .setPassword(passwordEncoder.encode(registerDto.password()))
                .setRole(registerDto.ROLE().name())
                .build();
        applicationUserRepository.save(user);
        String generatedToken = tokenService.generateToken(user);
        return new RegisterResponseDto(user.getEmail(), user.getRole());
    }
}
