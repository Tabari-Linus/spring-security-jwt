package com.lii.springsecurity.dto.reponse;

import java.time.LocalDateTime;

public record JwtAuthResponse(
        String accessToken,
        String tokenType
) {
    public JwtAuthResponse(String accessToken) {
        this(accessToken, "Bearer");
    }
}
