package org.pedro.controller;

import java.util.List;

import org.pedro.model.User;
import org.pedro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }
    
    @PostMapping("/delete")
    public ResponseEntity<List<User>> removeUser(@RequestBody List<User> users) {
    	userRepository.deleteAll(users);
    	return ResponseEntity.ok(users);
    }
    
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
    	return ResponseEntity.ok(userRepository.saveAndFlush(user));
    }
}