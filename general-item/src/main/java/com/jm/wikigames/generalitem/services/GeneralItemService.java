package com.jm.wikigames.generalitem.services;

import com.jm.wikigames.generalitem.model.GeneralItemGame;

import java.util.List;

public interface GeneralItemService {
    GeneralItemGame create(GeneralItemGame item);

    List<GeneralItemGame> getAllItems();

    GeneralItemGame getByName(String name);

    void delete(Long id);
}
