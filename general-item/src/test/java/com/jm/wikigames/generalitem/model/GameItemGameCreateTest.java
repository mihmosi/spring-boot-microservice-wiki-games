package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.repository.GameItemGameRepository;
import com.jm.wikigames.generalitem.services.impl.GameItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameItemGameCreateTest {

    @Mock
    private GameItemGameRepository repository;

    @InjectMocks
    private GameItemServiceImpl service;

    @Test
    void createGeneralItemGame(){
        GameItemGame game = new GameItemGame();

        when(repository.save(any(GameItemGame.class))).thenReturn(game);

        GameItemGame savedGame = service.create(game);

        Assertions.assertEquals(savedGame,game);
    }
}
