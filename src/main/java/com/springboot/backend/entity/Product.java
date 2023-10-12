package com.springboot.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "img")
    private String img;

    @Column(name = "name")
    private String name;

    @Column(name = "origin")
    private String origin;

    @Column(name = "price")
    private int price;

    @Column(name = "rate_point")
    private int rate_point;

    @Column(name = "brand_id")
    private int brand_id;

    @Column(name = "cate_id")
    private int cate_id;

    @Column(name = "user_id")
    private int user_id;

    public Product(String description, String img, String name, String origin, int price, int rate_point, int brand_id, int cate_id, int user_id) {
        this.description = description;
        this.img = img;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.rate_point = rate_point;
        this.brand_id = brand_id;
        this.cate_id = cate_id;
        this.user_id = user_id;
    }

    public Product() {
    }
}
