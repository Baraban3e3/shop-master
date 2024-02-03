package com.example.shop.controller;

import com.example.shop.domein.DTO.UserDTO;
import com.example.shop.domein.model.User;
import com.example.shop.mapper.UserMapper;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapperr;

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = mapperr.mapDTOToUser(userDTO);
        userService.registerUser(user);
    }

    @GetMapping("/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
