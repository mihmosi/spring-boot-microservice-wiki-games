package com.jm.wikigames.userservice.controllers;

import com.jm.wikigames.userservice.dto.UserDTO;
import com.jm.wikigames.userservice.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserModelController {

    private UserService userService;

    @DeleteMapping("/{id}")
    public void deleteItemByName(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void edit (@RequestBody UserDTO userDTO, @PathVariable long id) {
        try {
            userService.edit(userDTO);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException ("User with email address already exists");
        }
    }
}
