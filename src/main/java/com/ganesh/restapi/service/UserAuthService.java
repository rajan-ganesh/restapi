package com.ganesh.restapi.service;

import com.ganesh.restapi.model.UserModel;
import com.ganesh.restapi.repository.UserRepository;
import com.ganesh.restapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public UserModel signUp(UserModel userModel) {

        if (userRepository.findByUsername(userModel.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Hash the password
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

        return userRepository.save(userModel);
    }

    @Override
    public String login(String username, String password) {
        // Check if the username exists
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel == null) {
            throw new RuntimeException("User Does Not Exist");
        }

        // Check if the password is correct
        if (!passwordEncoder.matches(password, userModel.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        // If both username and password are correct, generate a JWT token
        return jwtTokenProvider.generateToken(username);
    }
}

