package com.jm.wikigames.generalitem.repository;

import com.jm.wikigames.generalitem.model.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameItemRepository extends JpaRepository<GameItem, Long> {
    GameItem findByName(String name);
}
