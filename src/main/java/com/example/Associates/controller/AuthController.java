package com.example.Associates.controller;

import com.example.Associates.dtos.AuthenticationDto;
import com.example.Associates.dtos.AuthenticationResponseDto;
import com.example.Associates.dtos.RegisterDto;
import com.example.Associates.dtos.RegisterResponseDto;
import com.example.Associates.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authServicee) {
        this.authService = authServicee;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationDto authenticationDto) {
        AuthenticationResponseDto authenticationResponseDto = authService.login(authenticationDto);
        if(authenticationResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(authenticationResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterDto registerDto) {
        RegisterResponseDto registerResponseDto = authService.register(registerDto);
        if(registerResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(registerResponseDto);
    }
}
