package com.lii.springsecurity.dto.reponse;

import java.time.LocalDateTime;
import java.util.List;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data,
        String timestamp,
        boolean error,
        List<String> errors
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", data,
                LocalDateTime.now().toString(), false, null);
    }

    public static <T> ApiResponse<T> error(String message, List<String> errors) {
        return new ApiResponse<>(false, message, null,
                LocalDateTime.now().toString(), true, errors);
    }
}