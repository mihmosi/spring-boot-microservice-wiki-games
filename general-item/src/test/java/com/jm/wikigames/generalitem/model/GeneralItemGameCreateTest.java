//package com.jm.wikigames.generalitem.model;
//
//import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
//import com.jm.wikigames.generalitem.services.impl.GeneralItemServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class GeneralItemGameCreateTest {
//
//    @Mock
//    private GeneralItemGameRepository repository;
//
//    @InjectMocks
//    private GeneralItemServiceImpl service;
//
//    @Test
//    void createGeneralItemGame(){
//        GeneralItemGame game = new GeneralItemGame();
//
//        when(repository.save(any(GeneralItemGame.class))).thenReturn(game);
//
//        GeneralItemGame savedGame = service.create(game);
//
//        Assertions.assertEquals(savedGame,game);
//    }
//}
