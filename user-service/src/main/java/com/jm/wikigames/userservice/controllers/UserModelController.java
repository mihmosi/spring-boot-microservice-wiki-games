package com.jm.wikigames.userservice.controllers;

import com.jm.wikigames.userservice.dto.UserDTO;
import com.jm.wikigames.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserModelController {

    private final UserService userService;

    @Autowired
    public UserModelController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItemByName(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO edit (@RequestBody UserDTO userDTO, @PathVariable long id) {
        try {
            return userService.update(userDTO);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException ("User with such name or email address already exists");
        }
    }
}
