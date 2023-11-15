package com.catalogmanagementsystem.serviceImpl;

import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.exceptions.ProductNotFoundException;
import com.catalogmanagementsystem.exceptions.ProductServiceException;
import com.catalogmanagementsystem.repository.ProductRepository;
import com.catalogmanagementsystem.services.ProductService;
import com.catalogmanagementsystem.exceptions.ProductAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    @Override
    public Product findBySku(String sku) {
        Product product = productRepository.findBySku(sku);
        if (product == null) {
            throw new ProductNotFoundException("Product with SKU " + sku + " not found");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        // Check if a product with the same SKU already exists
        Product existingProduct = productRepository.findBySku(product.getSku());
        if (existingProduct != null) {
            throw new ProductAlreadyExistsException("Product with SKU " + product.getSku() + " already exists");
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteBySku(String sku) {
        Product product = productRepository.findBySku(sku);
        if (product == null) {
            throw new ProductNotFoundException("Product with SKU " + sku + " not found");
        }
        productRepository.delete(product);
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }

    @Override
    public Product updateProduct(String sku, Product updatedProduct) {
        try {
            Product existingProduct = productRepository.findBySku(sku);

            if (existingProduct != null) {
                // Update fields of existingProduct with updatedProduct
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setPrice(updatedProduct.getPrice());

                // Save the updated product
                return productRepository.save(existingProduct);
            } else {
                throw new ProductNotFoundException("Product with SKU " + sku + " not found");
            }
        } catch (Exception e) {
            throw new ProductServiceException("Error updating product with SKU " + sku, e);
        }
	}
}

