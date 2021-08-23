package com.jm.wikigames.generalitem.model;

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

}
