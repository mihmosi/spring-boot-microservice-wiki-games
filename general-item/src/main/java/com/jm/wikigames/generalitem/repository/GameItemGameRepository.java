package com.jm.wikigames.generalitem.repository;

import com.jm.wikigames.generalitem.model.GameItemGame;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameItemGameRepository extends JpaRepository<GameItemGame, Long> {

    GameItemGame findByName(String name);

}
