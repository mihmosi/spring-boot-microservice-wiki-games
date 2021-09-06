package com.jm.wikigames.gameitem.services;

import com.jm.wikigames.gameitem.model.GameItem;

import java.util.List;

public interface GameItemService {
    GameItem create(GameItem item);

    List<GameItem> getAllItems();

    GameItem getByName(String name);

    GameItem getById(Long id);

    void delete(Long id);
}
