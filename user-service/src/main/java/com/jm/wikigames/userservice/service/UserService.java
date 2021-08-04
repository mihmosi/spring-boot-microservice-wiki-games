package com.jm.wikigames.userservice.service;

import java.util.List;

public interface UserService {

    UserModel create(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getByName(String name);

    UserModel getById(Long id);

    void delete(Long id);
}
