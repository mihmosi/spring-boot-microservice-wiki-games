package com.jm.wikigames.gameitem.model;

import com.jm.wikigames.gameitem.model.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameItemTest {

    @Test
    public void test_GeneralItemGame() {
        GameItem game = GameItem.builder()
            .id(1L)
            .name("Bloodborne")
            .dateOfCreation("14.07.2021")
            .genre("action/RPG")
            .heroes("human")
            .villains("monsters")
            .build();
        String result = game.getName();
        Assertions.assertEquals("Bloodborne",result);
    }

    @Test
    public void test_GeneralItemGameRelease() {
        GameItem game = GameItemDirector.builderRelease()
            .id(1L)
            .name("Bloodborne")
            .build();
        Assertions.assertEquals(Status.RELEASE,game.getStatus());
    }

    @Test
    public void test_GeneralItemGameProduction() {
        GameItem game = GameItemDirector.builderProduction()
            .id(1L)
            .name("Bloodborne")
            .build();
        Assertions.assertEquals(Status.PRODUCTION,game.getStatus());
    }

}
