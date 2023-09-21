package com.develhope.livespringboot.app.item.data;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

/**
 * the item DTO.
 * @author kamar baraka.*/

@Getter
@Setter
public class ItemDTO {

    private String details;

    private Time createdAt;
}
