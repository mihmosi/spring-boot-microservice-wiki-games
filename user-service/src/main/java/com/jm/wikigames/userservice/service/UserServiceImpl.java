package com.jm.wikigames.userservice.service;

import com.jm.wikigames.userservice.dto.UserDTO;
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
    public void edit(UserDTO userDTO) throws EntityNotFoundException, DataIntegrityViolationException {
        UserModel userModel = userRepository.getById(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setRoles(userDTO.getRoles());
        userRepository.saveAndFlush(userModel);
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
        if (s == null) {
            throw new UsernameNotFoundException("Unknown user: "+s);
        }
        return myUser;
    }
}
