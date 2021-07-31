package com.jm.wikigames.generalitem.services.impl;

import com.jm.wikigames.generalitem.model.RoleModel;
import com.jm.wikigames.generalitem.model.UserModel;
import com.jm.wikigames.generalitem.repository.UserRepository;
import com.jm.wikigames.generalitem.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel create(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserModel getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        userRepository.findByName(name);
    }

    @Override
    public List<RoleModel> getAllRolesById(Long userId) {
        return userRepository.getById(userId).getRoles();
    }
}
