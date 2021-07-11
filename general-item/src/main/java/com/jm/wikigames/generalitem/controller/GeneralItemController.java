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

    @Autowired
    public GeneralItemController(GeneralItemService generalItemService) {
        this.generalItemService = generalItemService;
    }

    @PostMapping("/items")
    public ResponseEntity<GeneralItemGame> addItem(@RequestBody GeneralItemGame generalItemGame){
        GeneralItemGame body = generalItemService.create(generalItemGame);
        return ResponseEntity.status(201).body(body);
    }

    @GetMapping("/items")
    public ResponseEntity<List<GeneralItemGame>> getAllItems(){
        List<GeneralItemGame> allItems = generalItemService.getAllItems();
        return ResponseEntity.ok().body(allItems);
    }

    @GetMapping("/items/{name}")
    public ResponseEntity<GeneralItemGame> findItemByName(@PathVariable String name){
        try{
            GeneralItemGame generalItemGame = generalItemService.findItemByName(name);
            return ResponseEntity.ok().body(generalItemGame);
        } catch (EntityNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/items/{name}")
    public ResponseEntity<GeneralItemGame> deleteItemByName(@PathVariable String name){
        try {
            Optional<GeneralItemGame> generalItemGame = generalItemService.findItemByName(name);
            generalItemService.delete(generalItemGame.get());
            return ResponseEntity.ok().body(generalItemGame.get());
        } catch (EntityNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
