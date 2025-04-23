package com.home.assignment.com.expense.tracker.Controller;

import com.home.assignment.com.expense.tracker.Service.UserService;
import com.home.assignment.com.expense.tracker.UserEntiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.registerUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User Created Successfully");
    }
}
