package com.dawudesign.springapi.controllers;

import com.dawudesign.springapi.entities.User;
import com.dawudesign.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> read() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User readById(@PathVariable Long id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/id")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User userUpdate = userRepository.findById(id).get();
        userUpdate.setUsername(user.getUsername());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setRole(user.getRole());
        return userRepository.save(userUpdate);
    }

    @DeleteMapping("/id")
    public Boolean delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }

}
