package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.services.GeneralItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralItemController {

	private GeneralItemService generalItemService;

	public GeneralItemController(GeneralItemService generalItemService) {
		this.generalItemService = generalItemService;
	}

	@PostMapping("/items")
	public GeneralItemGame addItem(@RequestBody GeneralItemGame generalItemGame) {
		return generalItemService.create(generalItemGame);
	}

	@GetMapping("/items")
	public List<GeneralItemGame> getAllItems() {
		return generalItemService.getAllItems();
	}

	@GetMapping("/items/{name}")
	public GeneralItemGame getItemByName(@PathVariable String name) {
		return generalItemService.getByName(name);
	}

	@GetMapping("/items/{id}")
	public GeneralItemGame getItemById(@PathVariable Long id) {
		return generalItemService.getById(id);
	}

	@DeleteMapping("/items/{name}")
	public void deleteItemByName(@PathVariable String name) {
		generalItemService.delete(generalItemService.getByName(name).getId());
	}

	@DeleteMapping("/items/{id}")
	public void deleteItemById(@PathVariable Long id) {
		generalItemService.delete(id);
	}
}
