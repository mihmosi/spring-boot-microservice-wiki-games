package com.jm.wikigames.userservice.controllers;

import com.jm.wikigames.userservice.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserModelController {

    private UserService userService;

    @DeleteMapping("/items/{name}")
    public void deleteItemByName(@PathVariable String name) {
        userService.delete(userService.getByName(name).getId());
    }

}
