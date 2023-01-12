package com.finalproject.user.service.impl;

import com.finalproject.user.DTO.UserDTO;
import com.finalproject.user.model.User;
import com.finalproject.user.repository.UserRepository;
import com.finalproject.user.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    static String passwordEncoder(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder.encode(rawPassword);
    }

    public void createUser(User user) {
        if (userRepository.findById(user.getUserName()).isPresent())
            throw new IllegalArgumentException("User already exist.");
        User newUser = new User(user.getUserName(), passwordEncoder(user.getPassword()), user.getName(), user.getDateOfBirth());
        userRepository.save(newUser);

    }


    public User getUser(String userName) {
        if (userRepository.findById(userName).isEmpty()) throw new IllegalArgumentException("User does not exist.");
        User user = userRepository.findById(userName).get();
        return user;
    }


    public void deleteUser(String userName, UserDTO userDTO) {
        if (userRepository.findById(userName).isEmpty()) throw new IllegalArgumentException("User does not exist.");
        User user = userRepository.findById(userName).get();
        if (!user.getPassword().equals(userDTO.getPassword()))
            throw new IllegalArgumentException("Invalid password,action denied");
        userRepository.deleteById(userName);
    }


    public void updatePassword(String userName, UserDTO userDTO) {
        if (userRepository.findById(userName).isEmpty()) throw new IllegalArgumentException("User does not exist.");
        User user = userRepository.findById(userName).get();
        if (!user.getPassword().equals(userDTO.getPassword()))
            throw new IllegalArgumentException("Invalid password,action denied");
        user.setPassword(userDTO.getNewPassword());
        userRepository.save(user);

    }
}
