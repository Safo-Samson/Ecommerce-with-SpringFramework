package com.safosamson.Ecommerce.repository;

import com.safosamson.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository is an interface for generic CRUD operations on a repository for a specific type,
// it takes the domain class to manage and the type of its primary key as type arguments.
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
