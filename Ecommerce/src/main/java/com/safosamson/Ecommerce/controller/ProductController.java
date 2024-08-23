package com.safosamson.Ecommerce.controller;



import com.safosamson.Ecommerce.model.Product;
import com.safosamson.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
   @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


}
