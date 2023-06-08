package com.jobsBoard.api.security.jwt;

import com.jobsBoard.api.security.UserPrinciple;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);

    Authentication getAuthentication(HttpServletRequest request);

    Claims extractClaims(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
