package com.finalproject.user.service.interfaces;

import com.finalproject.user.DTO.UserDTO;
import com.finalproject.user.model.User;

import java.util.Optional;

public interface IUserService {

    void createUser(User user);
    User getUser(String userName);
    void deleteUser(String userName, UserDTO userDTO);
    void updatePassword(String userName, UserDTO userDTO);


}
