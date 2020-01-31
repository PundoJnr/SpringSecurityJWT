package com.devsawe.demo.controllers;

import com.devsawe.demo.Service.UserService;
import com.devsawe.demo.entities.User;
import com.devsawe.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* @PostMapping("/users/register")
         public ResponseEntity<?> registerUser(@RequestBody User user) {
             user = userRepository.save(user);
             return ResponseEntity.ok(user);
         }*/
    @PostMapping(value = "/users/register")
    public ResponseEntity<Object> registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userService.registerUser(user);
        return ResponseEntity.ok(user);
    }
}