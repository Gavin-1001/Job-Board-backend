package com.jobsBoard.api.service.JwtRefreshTokenService;

import com.jobsBoard.api.entity.JwtRefreshToken;
import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.repository.JwtRefreshTokenRepository;
import com.jobsBoard.api.repository.UserRepository;
import com.jobsBoard.api.security.UserPrincipal;
import com.jobsBoard.api.security.jwt.JwtProvider;
import com.jobsBoard.api.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;

@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService{


    @Value("86400000")
    private Long REFRESH_EXPIRATION_IN_MS;

    @Autowired
    private JwtRefreshTokenRepository jwtRefreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public JwtRefreshToken createRefreshToken(String userId) {
        JwtRefreshToken jwtRefreshToken = new JwtRefreshToken();
        jwtRefreshToken.setTokenId(UUID.randomUUID().toString());
        jwtRefreshToken.setUserId(userId);
        jwtRefreshToken.setWhenTokenCreated(LocalDateTime.now());
        jwtRefreshToken.setWhenTokenExpirationDate(LocalDateTime.now().plus(REFRESH_EXPIRATION_IN_MS, ChronoUnit.MILLIS));

        return jwtRefreshTokenRepository.save(jwtRefreshToken);
    }

    @Override
    public AuthUser generateAccessTokenFromRefreshToken(String refreshTokenId){

        JwtRefreshToken jwtRefreshToken = jwtRefreshTokenRepository.findById(refreshTokenId).orElseThrow();

        if(jwtRefreshToken.getWhenTokenExpirationDate().isBefore(LocalDateTime.now())){
            throw new RuntimeException("JWT REFRESH TOKEN IS NOT VALID");
        }

        AuthUser user = userRepository.findById(jwtRefreshToken.getUserId()).orElseThrow();

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password((user.getPassword()))
                .authorities(Set.of(SecurityUtils.convertToAuthority(user.getRole().name())))
                .build();

        String accessToken = jwtProvider.generateToken(userPrincipal);

        user.setAccessToken(accessToken);
        user.setRefreshToken(refreshTokenId);

        return user;
    }

}
