package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    UserModel create(UserCreatingDTO userCreatingDto);

    List<UserModel> getAllUsers();

    UserModel getByName(String name);

    UserModel getById(Long id);

    void delete(Long id);
}
