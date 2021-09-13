package com.jm.wikigames.userservice.mapper;

import com.jm.wikigames.userservice.dto.UserDTO;
import com.jm.wikigames.userservice.model.UserModel;

public class UserMapper {

    public UserDTO userToDTO(UserModel user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());

        return userDTO;
    }

    public UserModel UserCreatingDTOtoUser(UserCreatingDTO userCreatingDTO){
        UserModel userModel = new UserModel();
        userModel.setName(userCreatingDTO.getName());
        userModel.setEmail(userCreatingDTO.getEmail());
        userModel.setRoles(userCreatingDTO.getRoles());
        userModel.setPassword(userCreatingDTO.getPassword);

        return userModel;
    }
}
