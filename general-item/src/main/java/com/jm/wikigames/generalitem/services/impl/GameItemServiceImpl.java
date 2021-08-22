package com.jm.wikigames.generalitem.services.impl;

import com.jm.wikigames.generalitem.model.GameItemGame;
import com.jm.wikigames.generalitem.repository.GameItemGameRepository;
import com.jm.wikigames.generalitem.services.GameItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameItemServiceImpl implements GameItemService {

    private final GameItemGameRepository gameItemGameRepository;

    public GameItemServiceImpl(GameItemGameRepository gameItemGameRepository) {
        this.gameItemGameRepository = gameItemGameRepository;
    }

    @Override
    @Transactional
    public GameItemGame create(GameItemGame item) {
        return gameItemGameRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameItemGame> getAllItems() {
        return gameItemGameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public GameItemGame getByName(String name) {
        return gameItemGameRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public GameItemGame getById(Long id) {
        return gameItemGameRepository.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        gameItemGameRepository.deleteById(id);
    }
}
