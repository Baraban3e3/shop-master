package com.example.shop.domein.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Product {

    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;
}


