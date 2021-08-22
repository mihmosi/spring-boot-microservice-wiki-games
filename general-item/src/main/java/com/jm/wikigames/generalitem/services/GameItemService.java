package com.jm.wikigames.generalitem.services;

import com.jm.wikigames.generalitem.model.GameItemGame;

import java.util.List;

public interface GameItemService {
    GameItemGame create(GameItemGame item);

    List<GameItemGame> getAllItems();

    GameItemGame getByName(String name);

    GameItemGame getById(Long id);

    void delete(Long id);
}
