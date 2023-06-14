package com.jobsBoard.api.service.UserService;

import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    AuthUser saveUser(AuthUser user);

    Optional<AuthUser> findByUsername(String username);

    List<User> getAllUsers();

}
