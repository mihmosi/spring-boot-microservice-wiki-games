package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GameItem;
import com.jm.wikigames.generalitem.services.GameItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameItemController {

	private GameItemService gameItemRepository;

	public GameItemController(GameItemService gameItemRepository) {
		this.gameItemRepository = gameItemRepository;
	}

	@PostMapping("/items")
	public GameItem addItem(@RequestBody GameItem gameItem) {
		return gameItemRepository.create(gameItem);
	}

	@GetMapping("/items")
	public List<GameItem> getAllItems() {
		return gameItemRepository.getAllItems();
	}

	@GetMapping("/items/{name}")
	public GameItem getItemByName(@PathVariable String name) {
		return gameItemRepository.getByName(name);
	}

	@GetMapping("/items/{id}")
	public GameItem getItemById(@PathVariable Long id) {
		return gameItemRepository.getById(id);
	}

	@DeleteMapping("/items/{name}")
	public void deleteItemByName(@PathVariable String name) {
		gameItemRepository.delete(gameItemRepository.getByName(name).getId());
	}

	@DeleteMapping("/items/{id}")
	public void deleteItemById(@PathVariable Long id) {
		gameItemRepository.delete(id);
	}
}
