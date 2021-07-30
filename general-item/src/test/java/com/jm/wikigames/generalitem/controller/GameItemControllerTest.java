//package com.jm.wikigames.generalitem.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jm.wikigames.generalitem.converter.Status;
//import com.jm.wikigames.generalitem.model.GameItem;
//import com.jm.wikigames.generalitem.services.GameItemService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(GameItemController.class)
//public class GameItemControllerTest {
//
//    @MockBean
//    private GameItemService itemService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void itemGame_whenAdd() throws Exception {
//        GameItem itemGame = new GameItem();
//        itemGame.setName("warcraft");
//        itemGame.setStatus(Status.REALISE);
//        Mockito.when(itemService.create(any(GameItem.class))).thenReturn(itemGame);
//        mockMvc.perform(post("/api/items")
//                .content(objectMapper.writeValueAsString(itemGame))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
//                .andExpect(jsonPath("$.name").value("warcraft"))
//                .andExpect(jsonPath("$.status").value(Status.REALISE));
//    }

//    @Test
//    public void itemGame_getByName() throws Exception {
//        GeneralItemGame itemGame = new GeneralItemGame();
//        itemGame.setName("warcraft");
//        itemGame.setGenre("strategy");
//        Mockito.when(itemService.getByName(Mockito.any())).thenReturn(itemGame);
//        mockMvc.perform(
//                get("/api/items/warcraft"))
//                .andExpect(content().json(objectMapper.writeValueAsString(itemGame)))
//                .andExpect(jsonPath("$.name").value("warcraft"))
//                .andExpect(jsonPath("$.genre").value("strategy"));
//    }
//
//    @Test
//    public void itemGame_getById() throws Exception {
//        GeneralItemGame itemGame = new GeneralItemGame();
//        itemGame.setId((long) 3);
//        itemGame.setName("warcraft");
//        itemGame.setGenre("strategy");
//        Mockito.when(itemService.getById(Mockito.any())).thenReturn(itemGame);
//        mockMvc.perform(
//                get("/api/items/3"))
//                .andExpect(jsonPath("$.id").value(3))
//                .andExpect(jsonPath("$.name").value("warcraft"))
//                .andExpect(jsonPath("$.genre").value("strategy"));
//    }
//
//
//    @Test
//    public void itemGame_givenAll() throws Exception {
//        GeneralItemGame itemGame = new GeneralItemGame();
//        itemGame.setName("warcraft");
//        itemGame.setGenre("strategy");
//        GeneralItemGame itemGame1 = new GeneralItemGame();
//        itemGame.setName("gta5");
//        itemGame.setGenre("action");
//        Mockito.when(itemService.getAllItems()).thenReturn(Arrays.asList(itemGame, itemGame1));
//        mockMvc.perform(
//                get("/api/items"))
//                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itemGame, itemGame1))));
//    }
//}
