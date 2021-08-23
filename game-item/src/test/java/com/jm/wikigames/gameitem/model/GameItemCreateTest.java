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
public class GameItemCreateTest {

    @Mock
    private GameItemRepository repository;

    @InjectMocks
    private GameItemServiceImpl service;

    @Test
    void createGeneralItemGame(){
        GameItem game = new GameItem();

        when(repository.save(any(GameItem.class))).thenReturn(game);

        GameItem savedGame = service.create(game);

        Assertions.assertEquals(savedGame,game);
    }
}
