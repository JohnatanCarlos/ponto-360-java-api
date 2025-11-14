package com.ponto_360.core.auth.domain.service;

import com.ponto_360.core.auth.domain.service.impl.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}