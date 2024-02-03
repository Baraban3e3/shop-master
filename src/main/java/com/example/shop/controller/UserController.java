package com.example.shop.controller;

import com.example.shop.DTO.UserDTO;
import com.example.shop.model.User;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = mapDTOToUser(userDTO);
        userService.registerUser(user);
    }

    private User mapDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
