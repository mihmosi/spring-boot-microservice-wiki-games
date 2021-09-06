package com.jm.wikigames.gameitem.model;

import com.jm.wikigames.gameitem.repository.GameItemRepository;
import com.jm.wikigames.gameitem.services.impl.GameItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameItemGetByIdTest {

    @Mock
    private GameItemRepository repository;

    @InjectMocks
    private GameItemServiceImpl service;

    @Test
    void getByIdTest(){
        GameItem game = GameItem.builder()
            .id(1L)
            .name("Last Guardian")
            .build();

        when(repository.getById(1L)).thenReturn(game);
        GameItem test = service.getById(1L);
        Assertions.assertEquals(test,game);
    }
}
