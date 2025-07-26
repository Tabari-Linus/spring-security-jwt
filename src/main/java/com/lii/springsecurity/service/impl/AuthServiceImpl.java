package com.lii.springsecurity.service.impl;

import com.lii.springsecurity.dto.request.LoginRequest;
import com.lii.springsecurity.dto.request.RegisterRequest;
import com.lii.springsecurity.enums.RoleName;
import com.lii.springsecurity.exception.EmailAlreadyExistException;
import com.lii.springsecurity.exception.UserNameAlreadyExistException;
import com.lii.springsecurity.model.Role;
import com.lii.springsecurity.model.User;
import com.lii.springsecurity.repository.UserRepository;
import com.lii.springsecurity.security.JwtTokenProvider;
import com.lii.springsecurity.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.lii.springsecurity.enums.RoleName.USER;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserRepository userRepository;

    @Override
    public String register(RegisterRequest registerRequest) {
        checkForExistingData(registerRequest);

        User user = new User();
        user.setUsername(registerRequest.userName());
        user.setEmail(registerRequest.email());
        user.setPassword(registerRequest.password());
        user.setRoles(Set.of(new Role(USER)));

        return "User registered successfully";
    }


    @Override
    public String login(LoginRequest loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.UserNameOrEmail(),
                loginDto.Password()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }

    private void checkForExistingData(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistException("Email already exists");
        }
        if (userRepository.existsByUsername(request.userName())) {
            throw new UserNameAlreadyExistException("Username already exists");
        }
    }
}
