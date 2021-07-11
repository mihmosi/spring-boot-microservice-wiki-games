package com.jm.wikigames.generalitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
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
    private GeneralItemGameRepository repository;

    @Test
    public void itemGame_whenAdd() throws Exception {
        GeneralItemGame itemGame = new GeneralItemGame();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(repository.save(Mockito.any())).thenReturn(itemGame));
        mockMvc.perform(
                post("/api/items")
                        .content(objectMapper.writeValueAsString(itemGame))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }

    @Test
    public void itemGame_getByName() throws Exception {
        GeneralItemGame itemGame = new GeneralItemGame();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(repository.findByName(Mockito.any())).thenReturn(Optional.of(itemGame));
        mockMvc.perform(
                get("/api/items/warcraft"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("warcraft"))
                .andExpect(jsonPath("$.genre").value("strategy"));
    }

    @Test
    public void itemGame_delete() throws Exception {
        GeneralItemGame itemGame = new GeneralItemGame();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        Mockito.when(repository.findByName(Mockito.any())).thenReturn(Optional.of(itemGame));
        mockMvc.perform(
                delete("/api/items/warcraft"))
                .andExpect(status().isOk());
    }

    @Test
    public void itemGame_dgivenAll() throws Exception {
        GeneralItemGame itemGame = new GeneralItemGame();
        itemGame.setName("warcraft");
        itemGame.setGenre("strategy");
        GeneralItemGame itemGame1 = new GeneralItemGame();
        itemGame.setName("gta5");
        itemGame.setGenre("action");
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(itemGame, itemGame1));
        mockMvc.perform(
                get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itemGame, itemGame1))));
    }
}
