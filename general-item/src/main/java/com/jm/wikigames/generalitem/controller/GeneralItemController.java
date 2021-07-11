package com.jm.wikigames.generalitem.controller;

import com.jm.wikigames.generalitem.model.GeneralItemGame;
import com.jm.wikigames.generalitem.services.GeneralItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class GeneralItemController {

    private GeneralItemService generalItemService;

    @Autowired
    public GeneralItemController(GeneralItemService generalItemService) {
        this.generalItemService = generalItemService;
    }

    @PostMapping("/items")
    public String addItem(@RequestBody GeneralItemGame generalItemGame){
        try {
            generalItemService.create(generalItemGame);
            return "Item " + generalItemGame.getName() + " added successfully";
        } catch (SQLIntegrityConstraintViolationException ex) {
            return "Item " + generalItemGame.getName() + " not add, item exists";
        }
    }

    @GetMapping("/items")
    public List<GeneralItemGame> getAllItems(){
        List<GeneralItemGame> allItems = generalItemService.getAllItems();
        return allItems;
    }

    @GetMapping("/items/{name}")
    public GeneralItemGame findItemByName(@PathVariable String name){
        try{
            GeneralItemGame generalItemGame = generalItemService.findItemByName(name);
            return generalItemGame;
        } catch (EntityNotFoundException ex){
            return null;
        }
    }

    @DeleteMapping("/items/{name}")
    public String deleteItemByName(@PathVariable String name){
        try {
            GeneralItemGame generalItemGame = generalItemService.findItemByName(name);
            generalItemService.delete(generalItemGame);
            return "Item " + generalItemGame.getName() + " delete successfully";
        } catch (EntityNotFoundException ex){
            return "Item witch name: " + name + "not found";
        }
    }

//    @PutMapping("/items")
//    public String updateItem(@RequestBody GeneralItemGame generalItemGame){
//        try {
//            GeneralItemGame generalItemGame = generalItemService.findItemById(generalItemGame.GetId());
//            generalItemService.updateItem(generalItemGame);
//            return "Item " + generalItemGame.getItemName() + " update successfully";
//        } catch (EntityNotFoundException ex){
//            return "Item witch id: " + generalItemGame.toString() + " not found";
//        }
//    }

//    @DeleteMapping("/items/{id}")
//    public String deleteItemById(@PathVariable long id){
//        try {
//            GeneralItemGame generalItemGame = generalItemService.findItemById(id);
//            generalItemService.deleteItem(generalItemGame);
//            return "Item " + generalItemGame.getItemName() + " delete successfully";
//        } catch (EntityNotFoundException ex){
//            return "Item witch id: " + id + "not found";
//        }
//    }

//    @GetMapping("/items/{id}")
//    public GeneralItemGame findItemById(@PathVariable long id){
//        try{
//            GeneralItemGame generalItemGame = generalItemService.findItemById(id);
//            return generalItemGame;
//        } catch (EntityNotFoundException ex){
//            return null;
//        }
//    }

}
