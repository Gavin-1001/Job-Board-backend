package com.jobsBoard.api.service.AuthenticationService;

import com.jobsBoard.api.entity.AuthUser;

public interface AuthenticationService {
    AuthUser signInAndReturnJWT(AuthUser signInRequest);
}
