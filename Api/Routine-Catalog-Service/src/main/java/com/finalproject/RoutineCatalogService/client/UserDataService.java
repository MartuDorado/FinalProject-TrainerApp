package com.finalproject.RoutineCatalogService.client;

import com.finalproject.RoutineCatalogService.DTO.UserDTO;
import com.finalproject.RoutineCatalogService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-data-service")
public interface UserDataService {

    @PostMapping("/user/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user);

    @GetMapping("/user/{user}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUser(@PathVariable(name = "user") String userName);

    @DeleteMapping("/user/delete/{user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "user") String userName, @RequestBody UserDTO userDTO);


    @PatchMapping("/user/update-password/{user}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePassword(@PathVariable(name = "user") String userName, @RequestBody UserDTO userDTO);
}
