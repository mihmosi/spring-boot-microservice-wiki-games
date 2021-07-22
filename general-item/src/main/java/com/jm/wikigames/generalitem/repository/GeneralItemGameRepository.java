package com.jm.wikigames.generalitem.repository;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneralItemGameRepository extends JpaRepository<GeneralItemGame, Long> {

    Optional<GeneralItemGame> findByName(String name);

}
