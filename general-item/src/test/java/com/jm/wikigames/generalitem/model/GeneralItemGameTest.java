package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneralItemGameTest {

    @Test
    public void getAllGeneralItemGames(){
        GeneralItemGame game = new GeneralItemGame();
        game.setId(1L);
        game.setName("Bloodborne");
        game.setDateOfCreation(new Date());
        game.setGenre("action/RPG");
        game.setHeroes("human");
        game.setVillains("monsters");
        GeneralItemGame game2 = new GeneralItemGame();
        game2.setId(2L);
        game2.setName("Last Guardian");
        game2.setDateOfCreation(new Date());
        game2.setGenre("adventure");
        game2.setHeroes("Boy");
        game2.setVillains("Tricos");

        List<GeneralItemGame> expected = GeneralItemGameRepository.findAll();
        List<GeneralItemGame> actual = new ArrayList<>();
        actual.add(game);
        actual.add(game2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getByName_GeneralItemGame(){
        GeneralItemGame game = new GeneralItemGame();
        game.setId(1L);
        game.setName("Nioh");
        game.setDateOfCreation(new Date());
        game.setGenre("action/RPG");
        game.setHeroes("William");
        game.setVillains("Iechaes");
        GeneralItemGame game1 = GeneralItemGameRepository.findByName("Nioh");
        Assertions.assertEquals(game, game1);

    }

    @Test
    public void getById_GeneralItemGame(){
        GeneralItemGame game = new GeneralItemGame();
        game.setId(1L);
        game.setName("Nioh");
        game.setDateOfCreation(new Date());
        game.setGenre("action/RPG");
        game.setHeroes("William");
        game.setVillains("Iechaes");
        GeneralItemGame game1 = GeneralItemGameRepository.findById(1L);
        Assertions.assertEquals(game, game1);
    }

    @Test
    public boolean delete_GeneralItemGame(){
        GeneralItemGame game = new GeneralItemGame();
        game.setId(1L);
        game.setName("Nioh");
        game.setDateOfCreation(new Date());
        game.setGenre("action/RPG");
        game.setHeroes("William");
        game.setVillains("Iechaes");
        GeneralItemGameRepository.delete(1L);
        return GeneralItemGameRepository.findById(1L) == null;
    }
}
