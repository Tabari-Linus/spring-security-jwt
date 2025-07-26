package com.lii.springsecurity.dto.request;

public record LoginRequest(
        String UserNameOrEmail,
        String Password
) {}
