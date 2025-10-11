package com.med.app.backend.controller;

import com.med.app.backend.model.user.User;
import com.med.app.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final UserService userService;


    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<User> getUserById(@PathVariable UUID uuid)
    {
        return ResponseEntity.ok(userService.getUserById(uuid));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username)
    {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
}
