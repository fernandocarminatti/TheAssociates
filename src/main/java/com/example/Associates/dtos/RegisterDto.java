package com.example.Associates.dtos;

import com.example.Associates.model.ApplicationUserRoleEnum;

public record RegisterDto(String username, String email, String password, ApplicationUserRoleEnum ROLE) {
}
