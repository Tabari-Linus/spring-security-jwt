package com.lii.springsecurity.service;

import com.lii.springsecurity.dto.request.LoginRequest;
import com.lii.springsecurity.dto.request.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest registerRequest);
    String login(LoginRequest loginDto);
}
