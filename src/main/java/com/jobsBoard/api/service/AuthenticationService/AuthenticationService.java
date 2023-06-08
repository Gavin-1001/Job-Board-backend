package com.jobsBoard.api.service.AuthenticationService;

import com.jobsBoard.api.entity.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
