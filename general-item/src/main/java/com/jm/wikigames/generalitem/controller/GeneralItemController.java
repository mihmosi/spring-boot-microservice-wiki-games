package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.services.GeneralItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class GeneralItemController {

    private GeneralItemService generalItemService;

    public GeneralItemController(GeneralItemService generalItemService) {
        this.generalItemService = generalItemService;
    }

    @PostMapping("/items")
    public GeneralItemGame addItem(@RequestBody GeneralItemGame generalItemGame){
        GeneralItemGame request = generalItemService.create(generalItemGame);
        return request;
    }

    @GetMapping("/items")
    public List<GeneralItemGame> getAllItems(){
        List<GeneralItemGame> allItems = generalItemService.getAllItems();
        return allItems;
    }

    @GetMapping("/items/{name}")
    public GeneralItemGame findItemByName(@PathVariable String name){
        GeneralItemGame generalItemGame = generalItemService.getByName(name);
        return generalItemGame;
    }

    @GetMapping("/items/{id}")
    public GeneralItemGame findItemById(@PathVariable Long id){
        GeneralItemGame generalItemGame = generalItemService.getById(id);
        return generalItemGame;
    }

    @DeleteMapping("/items/{name}")
    public void deleteItemByName(@PathVariable String name){
            generalItemService.delete(generalItemService.getByName(name).getId());
    }
}
