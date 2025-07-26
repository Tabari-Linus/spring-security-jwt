package com.lii.springsecurity.controller;

import com.lii.springsecurity.dto.reponse.ApiResponse;
import com.lii.springsecurity.dto.reponse.JwtAuthResponse;
import com.lii.springsecurity.dto.request.LoginRequest;
import com.lii.springsecurity.dto.request.RegisterRequest;
import com.lii.springsecurity.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(ApiResponse.success(authService.register(registerRequest)), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtAuthResponse>> login(@RequestBody LoginRequest loginDto){
        return new ResponseEntity<>(ApiResponse.success(new JwtAuthResponse( authService.login(loginDto))), HttpStatus.OK);
    }
}