package com.jm.wikigames.gameitem.controller;

import com.jm.wikigames.gameitem.model.GameItem;
import com.jm.wikigames.gameitem.services.GameItemService;
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
	public GameItem addItem(@RequestBody GameItem gameItem) {
		return gameItemService.create(gameItem);
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
