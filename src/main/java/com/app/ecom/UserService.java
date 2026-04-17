package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final List<User> userList = new ArrayList<>();
//    private long nextId = 1L;

    public List<User> fetchAllUsers(){

        return userRepository.findAll();
    }

    public void addUser(User user){
//        user.setId(nextId++);
        userRepository.save(user);
    }

    public Optional<User> fetchUser(Long id) {
       return userRepository.findById(id);
    }
    public boolean updateUser (Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }
}
