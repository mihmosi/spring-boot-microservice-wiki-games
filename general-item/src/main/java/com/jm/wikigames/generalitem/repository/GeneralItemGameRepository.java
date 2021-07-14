package com.jm.wikigames.generalitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm.wikigames.generalitem.model.GeneralItemGame;

public interface GeneralItemGameRepository extends JpaRepository<GeneralItemGame, Long>{
	public List<GeneralItemGame> findByName(String name);
}
