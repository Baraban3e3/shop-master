package com.example.shop.service;

import com.example.shop.domein.DTO.UserDTO;
import com.example.shop.domein.model.User;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper mapperr;

    public void registerUser(User user) {
         userRepository.save(user);
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.getUserByUsername(username);
        return mapperr.mapUserToDTO(user);
    }
}
