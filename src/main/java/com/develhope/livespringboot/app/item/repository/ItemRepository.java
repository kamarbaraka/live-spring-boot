package com.develhope.livespringboot.app.item.repository;

import com.develhope.livespringboot.app.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * the item repository.
 * @author kamar baraka.*/

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Item findItemByItemId(UUID itemId);
}
