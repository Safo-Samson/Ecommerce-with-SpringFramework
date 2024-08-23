package com.safosamson.Ecommerce.service;

import com.safosamson.Ecommerce.model.Product;
import com.safosamson.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int prodID) {
        return productRepository.findById(prodID).orElse(new Product());
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    // save() method, if product already exists, it will update the product, else it will add the product
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(int prodID) {
        productRepository.deleteById(prodID);
    }
}
