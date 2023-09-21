package com.develhope.livespringboot.app.item.service;

import com.develhope.livespringboot.app.item.data.ItemDTO;
import com.develhope.livespringboot.app.item.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * the item service.
 * @author kamar baraka.*/

public interface ItemService {

    ItemDTO createItem(ItemDTO itemDTO);
    ItemDTO getItemById(UUID itemId) throws NotFoundException;
    List<ItemDTO> getAllItems();
    void deleteItemById(UUID itemId) throws NotFoundException;
}
