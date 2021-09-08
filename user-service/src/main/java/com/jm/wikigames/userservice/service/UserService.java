package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
// TODO: убрать аннотацию @Transactional
    @Transactional
    UserModel create(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getByName(String name);

    UserModel getById(Long id);

    void delete(Long id);
}
