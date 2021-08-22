package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GameItemGame;
import com.jm.wikigames.generalitem.services.GameItemService;
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
	public GameItemGame addItem(@RequestBody GameItemGame gameItemGame) {
		return gameItemService.create(gameItemGame);
	}

	@GetMapping("/items")
	public List<GameItemGame> getAllItems() {
		return gameItemService.getAllItems();
	}

	@GetMapping("/items/{name}")
	public GameItemGame getItemByName(@PathVariable String name) {
		return gameItemService.getByName(name);
	}

	@GetMapping("/items/{id}")
	public GameItemGame getItemById(@PathVariable Long id) {
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
