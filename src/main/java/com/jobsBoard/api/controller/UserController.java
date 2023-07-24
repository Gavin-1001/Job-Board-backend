package com.jobsBoard.api.controller;

import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.entity.User;
import com.jobsBoard.api.repository.UserRepository;
import com.jobsBoard.api.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("profile")
    public ResponseEntity<AuthUser> addUserDetails(@RequestBody User user){
       // return ResponseEntity.ok(userService.saveUser(user));
        //do error handling once it works correctly
        return null;
    }

    @GetMapping("getUserDetails/{id}")
    public ResponseEntity<?> getUserDetails( @PathVariable Long id){
        return ResponseEntity.ok(userService.getUserDetailsById(id));
    //finds the user by id coming from the frontend, the id will come from currentUser.id and passed to the backend
    }
    

}
