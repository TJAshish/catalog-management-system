package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.Product;

import java.util.List;

public interface ProductService {
    Product findBySku(String sku);
    List<Product> findAll();
    Product save(Product product);
    void deleteBySku(String sku);
	Product findProductById(Long productId);
	Product updateProduct(String sku, Product updatedProduct);
}
