package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.converter.Status;
import com.jm.wikigames.generalitem.repository.GameItemRepository;
import com.jm.wikigames.generalitem.services.GameItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameItemTest {

    @Autowired
    private GameItemRepository repository;

    @Autowired
    private GameItemService service;

    @Test
    public void createGameItemTest() {
        Inside inside = new Inside();
        inside.setCharacters(new ArrayList<>());
        inside.setGenre(new ArrayList<>());
        inside.setLore("Lore");
        inside.setOriginalSource("OriginalSource");

        GameItem expectedGame = new GameItem(1L, "GTA", inside, Status.REALISE);
        repository.save(expectedGame);
        GameItem actualGame = service.getById(1L);
        assertEquals(expectedGame.getName(), actualGame.getName());
        assertEquals(expectedGame.getId(), actualGame.getId());
        assertEquals(expectedGame.getStatus(), actualGame.getStatus());
    }
}
