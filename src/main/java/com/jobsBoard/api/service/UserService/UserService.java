package com.jobsBoard.api.service.UserService;

import com.jobsBoard.api.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);
}
