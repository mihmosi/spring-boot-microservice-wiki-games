package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.repository.GeneralItemGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class GeneralItemController {

    private GeneralItemGameRepository generalItemGameRepository;

    @Autowired
    public GeneralItemController(GeneralItemGameRepository generalItemGameRepository) {
        this.generalItemGameRepository = generalItemGameRepository;
    }

    @PostMapping("/items")
    public String addItem(@RequestBody GeneralItemGame generalItemGame){
        try {
            generalItemGame.addItem(generalItemGame);
            return "Item " + generalItemGame.getItemName() + " added successfully";
        } catch (SQLIntegrityConstraintViolationException ex) {
            return "Item " + generalItemGame.getItemName() + " not add, item exists";
        }
    }

    @PutMapping("/items")
    public String updateItem(@RequestBody GeneralItemGame generalItemGame){
        try {
            GeneralItemGame generalItemGame = generalItemGameRepository.findItemById(generalItemGame.GetId());
            generalItemGameRepository.updateItem(generalItemGame);
            return "Item " + generalItemGame.getItemName() + " update successfully";
        } catch (EntityNotFoundException ex){
            return "Item witch id: " + generalItemGame.toString() + " not found";
        }
    }

    @GetMapping("/items")
    public List<GeneralItemGame> getAllItems(){
        List<GeneralItemGame> allItems = generalItemGameRepository.getAllItems();
        return allItems;
    }

    @GetMapping("/items/{id}")
    public GeneralItemGame findItemById(@PathVariable long id){
        try{
            GeneralItemGame generalItemGame = generalItemGameRepository.findItemById(id);
            return generalItemGame;
        } catch (EntityNotFoundException ex){
            return null;
        }
    }

    @DeleteMapping("/items/{id}")
    public String deleteItemById(@PathVariable long id){
        try {
            GeneralItemGame generalItemGame = generalItemGameRepository.findItemById(id);
            generalItemGameRepository.deleteItem(generalItemGame);
            return "Item " + generalItemGame.getItemName() + " delete successfully";
        } catch (EntityNotFoundException ex){
            return "Item witch id: " + id + "not found";
        }
    }


}
