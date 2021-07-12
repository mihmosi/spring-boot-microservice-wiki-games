package com.jm.wikigames.generalitem.services;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
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
        GeneralItemGame item = generalItemGameRepository.findByName(name);
        if (item == null) {
            throw new EntityNotFoundException();
        }
        return item;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        generalItemGameRepository.deleteById(id);
    }
}
