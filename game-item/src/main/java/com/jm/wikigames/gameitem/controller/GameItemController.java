package com.jm.wikigames.gameitem.controller;

import com.jm.wikigames.gameitem.dto.GameItemDTO;
import com.jm.wikigames.gameitem.model.GameItem;
import com.jm.wikigames.gameitem.services.GameItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameItemController {

	private GameItemService gameItemService;

	public GameItemController(GameItemService gameItemService) {
		this.gameItemService = gameItemService;
	}

	@PostMapping("/items")
	public GameItemDTO addItem(@RequestBody GameItemDTO gameItemDTO) {
		GameItem gameItem = new GameItem();
		gameItem.setName(gameItemDTO.getName());
		gameItem.setDateOfCreation(gameItemDTO.getDateOfCreation());
		gameItem.setGenre(gameItemDTO.getGenre());
		gameItem.setHeroes(gameItemDTO.getHeroes());
		gameItem.setVillains(gameItemDTO.getVillains());
		gameItem.setStatus(gameItemDTO.getStatus());
		gameItemService.create(gameItem);
		return gameItemDTO;
	}
	
	@GetMapping("/items")
	public List<GameItem> getAllItems() {
		return gameItemService.getAllItems();
	}

	@GetMapping("/items/{name}")
	public GameItem getItemByName(@PathVariable String name) {
		return gameItemService.getByName(name);
	}

	@GetMapping("/items/{id}")
	public GameItem getItemById(@PathVariable Long id) {
		return gameItemService.getById(id);
	}

	@DeleteMapping("/items/{name}")
	public void deleteItemByName(@PathVariable String name) {
		gameItemService.delete(gameItemService.getByName(name).getId());
	}
	
	@DeleteMapping("/items/{id}")
	public void deleteItemById(@PathVariable Long id) {
		gameItemService.delete(id);
	}
}
