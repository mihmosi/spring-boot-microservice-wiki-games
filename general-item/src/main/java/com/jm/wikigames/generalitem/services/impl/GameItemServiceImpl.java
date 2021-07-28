package com.jm.wikigames.generalitem.services.impl;

import com.jm.wikigames.generalitem.model.GameItem;
import com.jm.wikigames.generalitem.repository.GameItemRepository;
import com.jm.wikigames.generalitem.services.GameItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameItemServiceImpl implements GameItemService {

    private final GameItemRepository gameItemRepository;

    public GameItemServiceImpl(GameItemRepository gameItemRepository) {
        this.gameItemRepository = gameItemRepository;
    }

    @Override
    public GameItem create(GameItem item) {
        gameItemRepository.save(item);
        return item;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameItem> getAllItems() {
        return gameItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public GameItem getByName(String name) {
        return gameItemRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public GameItem getById(Long id) {
        return gameItemRepository.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        gameItemRepository.deleteById(id);
    }
}
