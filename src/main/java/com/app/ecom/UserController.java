package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/users")
    public class UserController {

        private final UserService userService;

    @GetMapping("/api/users")
    //@RequestMapping(value = "/api/users", method = RequestMethod.GET)         Method #2
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
//METHOD #2        return ResponseEntity.ok(userService.fetchAllUsers());

    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){

    return userService.fetchUser(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/users")
    public String createUser(@RequestBody User user){
        userService. addUser(user);
        return "User Added Successfully";
    }
    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody User updatedUser){
        boolean updated = userService.updateUser(id, updatedUser);
        if (updated)
            return ResponseEntity.ok("User Updated Succesfully");
        return ResponseEntity.notFound().build();
    }
}
