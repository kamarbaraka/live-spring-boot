package com.develhope.livespringboot.app.item.controller;

import com.develhope.livespringboot.app.item.data.ItemDTO;
import com.develhope.livespringboot.app.item.exception.NotFoundException;
import com.develhope.livespringboot.app.item.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * the item controller.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/api/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(){

        /*get all items*/
        List<ItemDTO> allItems = this.itemService.getAllItems();

        /*return a payload containing all the entities*/
        return ResponseEntity.ok(allItems);
    }

    @GetMapping(value = {"{id}"})
    public ResponseEntity<ItemDTO> getItemById(@PathVariable("id")UUID uuid)throws NotFoundException {

        /*get the Item*/
        ItemDTO itemDTO = this.itemService.getItemById(uuid);
        /*return the item DTO*/
        return ResponseEntity.ok(itemDTO);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){

        /*persist the item*/
        ItemDTO item = this.itemService.createItem(itemDTO);
        /*return the dto*/
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping(value = {"{id}"})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteItemById(@PathVariable("id") UUID uuid) throws NotFoundException {

        /*delete the item by id*/
        this.itemService.deleteItemById(uuid);
    }
}
