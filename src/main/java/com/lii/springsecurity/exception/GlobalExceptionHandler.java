package com.lii.springsecurity.exception;

import com.lii.springsecurity.dto.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleUsernameNotFoundException(UsernameNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ex.getMessage(), null));
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserAlreadyExistException(UserAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage(), null));
    }

    @ExceptionHandler(value = UserNameAlreadyExistException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserNameAlreadyExistException(UserNameAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage(), null));
    }

    @ExceptionHandler(value = EmailAlreadyExistException.class)
    public ResponseEntity<ApiResponse<Void>> handleEmailAlreadyExistException(EmailAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage(), null));
    }
}
