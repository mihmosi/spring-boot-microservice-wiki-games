package com.jm.wikigames.generalitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm.wikigames.generalitem.model.GeneralItemGame;

public interface GeneralItemGameRepository extends JpaRepository<GeneralItemGame, Long>{
}
