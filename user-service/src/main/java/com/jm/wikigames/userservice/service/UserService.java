package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.model.UserModel;


import java.util.List;

public interface UserService {

    UserModel create(UserModel userModel);

    UserModel update(UserCreatingDTO userDTO);

    List<UserModel> getAllUsers();

    UserModel getByName(String name);

    UserModel getById(Long id);

    void delete(Long id);
}
