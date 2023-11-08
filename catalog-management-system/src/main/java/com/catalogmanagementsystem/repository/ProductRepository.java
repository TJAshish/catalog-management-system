package com.catalogmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogmanagementsystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySku(String sku);
    void deleteBySku(String sku);
}

