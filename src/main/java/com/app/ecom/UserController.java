package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
    public class UserController {
        private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.fetchUser(id);
    }

    @PostMapping("/api/users")
    public String createUser(@RequestBody User user){
        userService. addUser(user);
        return "User Added Successfully";
    }
}
