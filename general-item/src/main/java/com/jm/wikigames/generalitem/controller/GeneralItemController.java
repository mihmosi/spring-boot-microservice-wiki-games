package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GameItem;
import com.jm.wikigames.generalitem.services.GameItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/game-item")
public class GeneralItemController {

    private final GameItemService gameItemService;

    public GeneralItemController(GameItemService gameItemService) {
        this.gameItemService = gameItemService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public GameItem createGameItem(@RequestBody GameItem gameItem) {
        return gameItemService.create(gameItem);
    }
}
