//package com.jm.wikigames.generalitem.model;
//
//import com.jm.wikigames.generalitem.services.impl.GeneralItemServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class GeneralItemGameGetByIdTest {
//
//    @Mock
//    private GeneralItemGameRepository repository;
//
//    @InjectMocks
//    private GeneralItemServiceImpl service;
//
//    @Test
//    void getByIdTest(){
//        GeneralItemGame game = new GeneralItemGame();
//        game.setId(1L);
//        game.setName("Last Guardian");
//
//        when(repository.findById(1L)).thenReturn(Optional.of(game));
//        GeneralItemGame test = service.getById(1L);
//        Assertions.assertEquals(test,game);
//    }
//}
