package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> patchUser(Long id, Map<String, Object> updates) {
        return userRepository.findById(id).map(user -> {
            if (updates.containsKey("name")) {
                user.setName(updates.get("name").toString());
            }
            if (updates.containsKey("email")) {
                user.setEmail(updates.get("email").toString());
            }
            if (updates.containsKey("age")) {
                user.setAge(Integer.parseInt(updates.get("age").toString()));
            }
            return userRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
