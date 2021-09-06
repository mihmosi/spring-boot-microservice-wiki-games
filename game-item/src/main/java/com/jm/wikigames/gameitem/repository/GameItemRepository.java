package com.jm.wikigames.gameitem.repository;

import com.jm.wikigames.gameitem.model.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameItemRepository extends JpaRepository<GameItem, Long> {

    GameItem findByName(String name);

}
