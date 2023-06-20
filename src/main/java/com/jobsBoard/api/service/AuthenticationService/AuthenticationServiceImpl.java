package com.jobsBoard.api.service.AuthenticationService;

import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.entity.Role;
import com.jobsBoard.api.repository.UserAuthRepository;
import com.jobsBoard.api.repository.UserRepository;
import com.jobsBoard.api.security.UserPrincipal;
import com.jobsBoard.api.security.jwt.JwtProvider;
import com.jobsBoard.api.service.JwtRefreshTokenService.JwtRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;

    @Override
    public AuthUser signInAndReturnJWT(AuthUser signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);


        AuthUser signInUser = userPrincipal.getUser();
        signInUser.setAccessToken(jwt);
        signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getId()).getTokenId());

        return signInUser;
    }



    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public AuthUser saveUser(AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(Objects.equals(user.getJobSeekerBool(), "true")){
            user.setRole(Role.USER);
        }else {
            user.setRole(Role.EMPLOYER);
        }
        user.setRole(Role.USER);
        return userAuthRepository.save(user);
    }

    @Override
    public Optional<AuthUser> findByUsername(String username){
        return userAuthRepository.findByUsername(username);
    }



}
