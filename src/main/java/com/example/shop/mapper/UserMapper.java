package com.example.shop.mapper;

import com.example.shop.domein.DTO.ProductDTO;
import com.example.shop.domein.DTO.UserDTO;
import com.example.shop.domein.model.Product;
import com.example.shop.domein.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper mapper;
    public User mapDTOToUser(UserDTO userDTO){
        return mapper.map(userDTO, User.class);
    }
    public UserDTO mapUserToDTO(User user){
        return mapper.map(user, UserDTO.class);
    }
}
