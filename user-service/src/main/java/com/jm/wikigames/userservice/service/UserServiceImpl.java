package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.model.UserModel;
import com.jm.wikigames.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel create(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    @Override
    @Transactional
    public UserModel update(UserCreatingDTO creatingDTO) throws EntityNotFoundException, DataIntegrityViolationException {
        UserModel userModel = userRepository.findByName(creatingDTO.getName());
        userModel.setName(creatingDTO.getName());
        userModel.setPassword(passwordEncoder.encode(creatingDTO.getPassword()));
        userModel.setEmail(creatingDTO.getEmail());
        userModel.setRoles(creatingDTO.getRoles());
        return userRepository.saveAndFlush(userModel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel myUser = userRepository.findByName(s);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + s);
        }
        return myUser;
    }
}
