package com.develhope.livespringboot.app.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.UUID;

/**
 * an item entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(unique = true, updatable = false)
    private UUID itemId;
    private String details;
    @Column(updatable = false)
    private final Time createdAt = Time.valueOf(LocalTime.now());
}
