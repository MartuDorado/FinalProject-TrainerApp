package com.finalproject.user.controller.impl;

import com.finalproject.user.DTO.UserDTO;
import com.finalproject.user.controller.interfaces.IUserController;
import com.finalproject.user.model.User;
import com.finalproject.user.service.interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements IUserController {

    @Autowired
    IUserService iUserService;


    @PostMapping("/user/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
         iUserService.createUser(user);
    }

    @GetMapping("/user/{user}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUser(@PathVariable(name = "user") String userName) {
        return iUserService.getUser(userName);
    }

    @DeleteMapping("/user/delete/{user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "user")String userName, @RequestBody UserDTO userDTO) {
        iUserService.deleteUser(userName,userDTO);
    }

    @PatchMapping("/user/update-password/{user}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePassword(@PathVariable(name = "user") String userName, @RequestBody UserDTO userDTO) {
      iUserService.updatePassword(userName,userDTO);
    }
}
