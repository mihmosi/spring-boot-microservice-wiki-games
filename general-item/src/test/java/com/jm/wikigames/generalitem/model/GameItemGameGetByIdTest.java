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
public class GameItemGameGetByIdTest {

    @Mock
    private GameItemGameRepository repository;

    @InjectMocks
    private GameItemServiceImpl service;

    @Test
    void getByIdTest(){
        GameItemGame game = new GameItemGame();
        game.setId(1L);
        game.setName("Last Guardian");

        when(repository.getById(1L)).thenReturn(game);
        GameItemGame test = service.getById(1L);
        Assertions.assertEquals(test,game);
    }
}
