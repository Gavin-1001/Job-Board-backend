package com.jobsBoard.api.service.UserService;

import com.jobsBoard.api.entity.Role;
import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.entity.User;
import com.jobsBoard.api.repository.UserAuthRepository;
import com.jobsBoard.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public AuthUser saveUser(AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userAuthRepository.save(user);
    }

    @Override
    public Optional<AuthUser> findByUsername(String username){
        return userAuthRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
