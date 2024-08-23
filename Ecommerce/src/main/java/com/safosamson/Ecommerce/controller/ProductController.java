package com.safosamson.Ecommerce.controller;

import com.safosamson.Ecommerce.model.Product;
import com.safosamson.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{prodID}")
    public Product getProductById(int prodID) {
        return productService.getProductById(prodID);
    }

    @PostMapping("/product")
    public Product addProduct( @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct( @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{prodID}")
    public void deleteProduct(@PathVariable int prodID) {
        productService.deleteProduct(prodID);
    }


}
