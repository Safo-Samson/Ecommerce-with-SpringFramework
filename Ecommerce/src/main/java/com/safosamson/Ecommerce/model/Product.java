package com.safosamson.Ecommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product{

    @Id
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private String category;
    private Date releaseDate;
    private boolean isAvailable;
    private int quantity;
}
