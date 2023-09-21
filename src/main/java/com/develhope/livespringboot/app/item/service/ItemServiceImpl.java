package com.develhope.livespringboot.app.item.service;

import com.develhope.livespringboot.app.item.data.ItemDTO;
import com.develhope.livespringboot.app.item.entity.Item;
import com.develhope.livespringboot.app.item.exception.NotFoundException;
import com.develhope.livespringboot.app.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * the item service implementation.
 * @author kamar baraka.*/

@Service
@Primary
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ModelMapper mapper;

    private Item findOrThrow(final UUID uuid) throws NotFoundException {

        /*get the item by ID or throw exception*/
        return itemRepository.findById(uuid).orElseThrow(() -> new NotFoundException("resource not found"));

    }

    private Item convertToEntity(ItemDTO itemDTO){

        /*convert the DTO to Entity*/
        return mapper.map(itemDTO, Item.class);
    }

    private ItemDTO convertToDTO(Item item){

        /*convert the item to DTO*/
        return mapper.map(item, ItemDTO.class);
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {

        /*convert the Dto to entity*/
        Item item = this.convertToEntity(itemDTO);
        /*persist the item and convert and return the dto*/
        return convertToDTO(itemRepository.save(item));
    }

    @Override
    public ItemDTO getItemById(final UUID itemId) throws NotFoundException {

        /*get the item by ID*/
        Item item = this.findOrThrow(itemId);
        /*convert to DTO and return*/
        return this.convertToDTO(item);
    }

    @Override
    public List<ItemDTO> getAllItems() {

        /*get all items*/
        List<Item> allItems = this.itemRepository.findAll();
        /*convert the items to DTO and return*/
        return allItems.stream().map(this::convertToDTO).toList();
    }

    @Override
    public void deleteItemById(final UUID itemId) throws NotFoundException {

        /*check if the user exists*/
        this.findOrThrow(itemId);
        /*delete the user*/
        this.itemRepository.deleteById(itemId);

    }
}
