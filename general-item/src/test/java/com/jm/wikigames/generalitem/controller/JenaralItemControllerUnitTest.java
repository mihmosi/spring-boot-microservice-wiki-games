package com.jm.wikigames.generalitem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
import com.jm.wikigames.generalitem.services.GeneralItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityNotFoundException;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class JenaralItemControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private GeneralItemService itemService;

    @Test
    public void itemGame_whenAdd() throws Exception {
        GeneralItemGame itemGame = GeneralItemGame.builder()
            .name("warcraft")
            .genre("strategy")
            .build();
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
        GeneralItemGame itemGame = GeneralItemGame.builder()
            .name("warcraft")
            .genre("strategy")
            .build();
        Mockito.when(itemService.getByName(Mockito.any())).thenReturn(itemGame);
        mockMvc.perform(
                get("/api/items/warcraft"))
                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }

    @Test
    public void itemGame_getById() throws Exception {
        GeneralItemGame itemGame = GeneralItemGame.builder()
            .id((long) 3)
            .name("warcraft")
            .genre("strategy")
            .build();
        Mockito.when(itemService.getById(Mockito.any())).thenReturn(itemGame);
        mockMvc.perform(
                get("/api/items/3"))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }
    

    @Test
    public void itemGame_givenAll() throws Exception {
        GeneralItemGame itemGame = GeneralItemGame.builder()
            .name("warcraft")
            .genre("strategy")
            .build();
        GeneralItemGame itemGame1 = GeneralItemGame.builder()
            .name("gta5")
            .genre("action")
            .build();
        Mockito.when(itemService.getAllItems()).thenReturn(Arrays.asList(itemGame, itemGame1));
        mockMvc.perform(
                get("/api/items"))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itemGame, itemGame1))));
    }
}
