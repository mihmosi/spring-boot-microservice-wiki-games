package com.jm.wikigames.userservice.controllers;

import com.jm.wikigames.userservice.dto.UserCreatingDTO;
import com.jm.wikigames.userservice.model.UserModel;
import com.jm.wikigames.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserModelController {

    private final UserService userService;

    @DeleteMapping("/delete/{id}")
    public void deleteItemByName(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserModel edit (@RequestBody UserCreatingDTO creatingDTO, @PathVariable long id) {
        return userService.update(creatingDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String errorMessage (DataIntegrityViolationException e) {
        return "User with such name or email address already exists";
    }
}