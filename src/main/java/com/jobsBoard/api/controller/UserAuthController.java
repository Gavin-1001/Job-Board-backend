package com.jobsBoard.api.controller;

import com.jobsBoard.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtRefreshTokenService jwtRefreshTokenService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> signUp(@RequestBody User user) throws UsernameExistsException {
//        if (userService.findByUsername(user.getUsername()).isPresent())  {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//
//        }
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> signIn(@RequestBody User user){
//        return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
//    }
//
//    @PostMapping("/refreshToken")
//    public ResponseEntity<?> refreshToken(@RequestParam String token){
//        return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
//    }


}
