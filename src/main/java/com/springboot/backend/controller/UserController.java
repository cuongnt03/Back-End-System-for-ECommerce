package com.springboot.backend.controller;

import com.springboot.backend.entity.User;
import com.springboot.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // build get all Users REST API
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // https:/localhost:8080/api/Users/{id}
    @GetMapping("{id}")
    public ResponseEntity<User> findUser(@PathVariable("id") int UserId) {
        return new ResponseEntity<>(userService.findUser(UserId), HttpStatus.OK);
    }

    // build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int UserId, @RequestBody User User) {
        return new ResponseEntity<>(userService.updateUser(User, UserId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int UserId) {
        userService.deleteUser(UserId);
        return new ResponseEntity<>("Remove User successfully!", HttpStatus.OK);
    }
}
