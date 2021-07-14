package com.jm.wikigames.generalitem.services.impl;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
import com.jm.wikigames.generalitem.services.GeneralItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GeneralItemServiceImpl implements GeneralItemService {

    private final GeneralItemGameRepository generalItemGameRepository;

    public GeneralItemServiceImpl(GeneralItemGameRepository generalItemGameRepository) {
        this.generalItemGameRepository = generalItemGameRepository;
    }

    @Override
    @Transactional
    public GeneralItemGame create(GeneralItemGame item) {
        generalItemGameRepository.save(item);
        return item;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GeneralItemGame> getAllItems() {
        return generalItemGameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public GeneralItemGame getByName(String name) {
        return generalItemGameRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    @Transactional(readOnly = true)
    public GeneralItemGame getById(Long id) {
        return generalItemGameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        generalItemGameRepository.deleteById(id);
    }
}
