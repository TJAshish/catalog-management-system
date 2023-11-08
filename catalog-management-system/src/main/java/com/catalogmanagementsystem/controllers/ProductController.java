package com.catalogmanagementsystem.controllers;

import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.exceptions.ProductNotFoundException;
import com.catalogmanagementsystem.exceptions.ProductAlreadyExistsException;
import com.catalogmanagementsystem.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

    @GetMapping("/{sku}")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku) {
        try {
            Product product = productService.findBySku(sku);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        try {
            Product savedProduct = productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (ProductAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }
    @PutMapping("/{sku}")
    public ResponseEntity<Product> updateProductBySku(@PathVariable String sku, @Valid @RequestBody Product updatedProduct) {
        try {
            Product existingProduct = productService.findBySku(sku);
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());

            Product savedProduct = productService.save(existingProduct);
            return ResponseEntity.ok(savedProduct);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> deleteProductBySku(@PathVariable String sku) {
        try {
            productService.deleteBySku(sku);
            return ResponseEntity.noContent().build();
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

