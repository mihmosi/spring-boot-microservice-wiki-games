package com.jm.wikigames.generalitem.services;

import com.jm.wikigames.generalitem.model.RoleModel;
import com.jm.wikigames.generalitem.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel create(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    UserModel getUserByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);

    List<RoleModel> getAllRolesById(Long userId);
}
