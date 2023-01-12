package com.finalproject.user.controller.interfaces;

import com.finalproject.user.DTO.UserDTO;
import com.finalproject.user.model.User;

public interface IUserController {
    void createUser(User user);
    User getUser(String userName);
    void deleteUser(String userName, UserDTO userDTO);
    void updatePassword(String userName, UserDTO userDTO);
}
