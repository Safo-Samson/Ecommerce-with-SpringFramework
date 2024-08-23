package com.safosamson.Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity // This tells Hibernate to make a table out of this class
public class Product {
    @Id
    @JsonProperty("prodID") // change the name of the field in the JSON response from prodId to prodID
    private int prodId;

    private String prodName;
    private int price;

    public Product() {
    }

    public Product(int prodID, String prodName, int price) {
        this.prodId = prodID;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
