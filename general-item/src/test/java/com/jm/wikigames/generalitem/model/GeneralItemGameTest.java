package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.model.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralItemGameTest {

    @Test
    public void test_GeneralItemGame() {
        GeneralItemGame game = GeneralItemGame.builder()
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
        GeneralItemGame game = GeneralItemGameDirector.builderRelease()
            .id(1L)
            .name("Bloodborne")
            .dateOfCreation("14.07.2021")
            .genre("action/RPG")
            .heroes("human")
            .villains("monsters")
            .build();
        Status result = game.getStatus();
        Assertions.assertEquals("RELEASE",result.name());
    }

    @Test
    public void test_GeneralItemGameProduction() {
        GeneralItemGame game = GeneralItemGameDirector.builderProduction()
            .id(1L)
            .name("Bloodborne")
            .dateOfCreation("14.07.2021")
            .genre("action/RPG")
            .heroes("human")
            .villains("monsters")
            .build();
        Status result = game.getStatus();
        Assertions.assertEquals("PRODUCTION",result.name());
    }

}
