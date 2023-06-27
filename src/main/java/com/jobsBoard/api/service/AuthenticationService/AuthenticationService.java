package com.jobsBoard.api.service.AuthenticationService;

import com.jobsBoard.api.entity.AuthUser;

import java.util.Optional;

public interface AuthenticationService {
    AuthUser signInAndReturnJWT(AuthUser signInRequest);

    AuthUser saveUser(AuthUser user);

    Optional<AuthUser> findByUsername(String username);

    AuthUser getUserId(String id);
}
