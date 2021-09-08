package com.jm.wikigames.socialservice.controller;

import com.jm.wikigames.socialservice.model.Social;
import com.jm.wikigames.socialservice.service.SocialService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class SocialController {

    private final SocialService socialService;

    @GetMapping("/{id}")
    private Social getSocialById(@PathVariable Long id, @RequestParam("increment") Boolean inc){
        return socialService.incrementSocialCount(id, inc);
    }






}
