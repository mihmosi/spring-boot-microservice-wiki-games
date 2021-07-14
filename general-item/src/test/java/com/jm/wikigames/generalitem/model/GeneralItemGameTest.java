package com.jm.wikigames.generalitem.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralItemGameTest {

    @Test
    public void testSetter_GeneralItemGame() {
        GeneralItemGame game = new GeneralItemGame();
        game.setId(1L);
        game.setName("Bloodborne");
        game.setDateOfCreation("14.07.2021");
        game.setGenre("action/RPG");
        game.setHeroes("human");
        game.setVillains("monsters");
        String result ="GeneralItemGame(id=1, name=Bloodborne, dateOfCreation=14.07.2021, genre=action/RPG, heroes=human, villains=monsters)";
        Assertions.assertEquals(result,game.toString());

    }

    @Test
    public void testGetter_GeneralItemGame(){
        GeneralItemGame game = new GeneralItemGame(1L,"Bloodborne","14.07.2021","action/RPG","human","monsters");
        String result = game.getGenre();
        Assertions.assertEquals("action/RPG", result);
    }
}
