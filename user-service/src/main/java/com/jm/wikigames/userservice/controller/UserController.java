package com.jm.wikigames.userservice.controller;

import com.jm.wikigames.userservice.model.UserModel;
import com.jm.wikigames.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/show") //работает вроде
    public List <UserModel> getAllUsers(){
        return userService.getAllUsers ();
    }
}