package com.example.democarcrud.Controller;

import com.example.democarcrud.Entities.User;
import com.example.democarcrud.Respository.UserRepository;
import com.example.democarcrud.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    @GetMapping("/all")
    public ResponseEntity<User> allUser(@RequestParam("email") String email) throws IOException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        System.out.println(user);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.CreateUser(user);
    }
}
