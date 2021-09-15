package com.jm.wikigames.userservice.mapper;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.dto.UserDTO;
import com.jm.wikigames.userservice.model.UserModel;

public class UserMapper {

    public UserDTO toDTO(UserModel user) {
        return new UserDTO(
                user.getName(),
                user.getEmail(),
                user.getRoles());
    }

    public UserModel toUser(UserCreatingDTO userCreatingDTO) {
        return new UserModel(
                userCreatingDTO.getName(),
                userCreatingDTO.getPassword(),
                userCreatingDTO.getEmail(),
                userCreatingDTO.getRoles());
    }
}
