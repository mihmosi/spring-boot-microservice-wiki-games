package com.jm.wikigames.gameitem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.gameitem.model.GameItem;
import com.jm.wikigames.gameitem.services.GameItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class JenaralItemControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private GameItemService itemService;

    @Test
    public void itemGame_whenAdd() throws Exception {
        GameItem itemGame = new GameItem();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(itemService.create(Mockito.any())).thenReturn(itemGame);
        mockMvc.perform(
                post("/api/items")
                        .content(objectMapper.writeValueAsString(itemGame))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }

    @Test
    public void itemGame_getByName() throws Exception {
        GameItem itemGame = new GameItem();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(itemService.getByName(Mockito.anyString())).thenReturn(itemGame);
        mockMvc.perform(
                get("/api/items/name/warcraft"))
                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }

    @Test
    public void itemGame_getById() throws Exception {
        GameItem itemGame = new GameItem();
        itemGame.setId((long) 3);
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(itemService.getById(Mockito.anyLong())).thenReturn(itemGame);
        mockMvc.perform(
                get("/api/items/id/3"))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }
    

    @Test
    public void itemGame_givenAll() throws Exception {
        GameItem itemGame = new GameItem();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        GameItem itemGame1 = new GameItem();
        itemGame.setName("gta5");
        itemGame.setGenre("action");
        Mockito.when(itemService.getAllItems()).thenReturn(Arrays.asList(itemGame, itemGame1));
        mockMvc.perform(
                get("/api/items"))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itemGame, itemGame1))));
    }
}
