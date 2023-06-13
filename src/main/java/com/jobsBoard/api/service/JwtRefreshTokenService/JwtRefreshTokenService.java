package com.jobsBoard.api.service.JwtRefreshTokenService;

import com.jobsBoard.api.entity.JwtRefreshToken;
import com.jobsBoard.api.entity.AuthUser;

public interface JwtRefreshTokenService {

    JwtRefreshToken createRefreshToken(String userId);

    AuthUser generateAccessTokenFromRefreshToken(String refreshTokenId);
}
