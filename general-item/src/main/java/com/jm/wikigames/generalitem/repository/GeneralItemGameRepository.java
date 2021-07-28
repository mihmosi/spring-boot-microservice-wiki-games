package com.jm.wikigames.generalitem.repository;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GeneralItemGameRepository extends JpaRepository<GeneralItemGame, Long> {

    GeneralItemGame findByName(String name);

}
