package com.catalogmanagementsystem.serviceImpl;

import com.catalogmanagementsystem.entities.Product;
import com.catalogmanagementsystem.exceptions.ProductNotFoundException;
import com.catalogmanagementsystem.repository.ProductRepository;
import com.catalogmanagementsystem.services.ProductService;
import com.catalogmanagementsystem.exceptions.ProductAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Product> updateProduct(String sku, Product updatedProduct) {
		{
	        try {
	            // Retrieve the existing product by SKU
	            Product existingProduct = productRepository.findBySku(sku);

	            // Update the fields with the new values
	            existingProduct.setProductName(updatedProduct.getProductName());
	            existingProduct.setDescription(updatedProduct.getDescription());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            existingProduct.setStockAvailability(updatedProduct.getStockAvailability());

	            // Save the updated product
	            Product savedProduct = productRepository.save(existingProduct);

	            // Return the updated product in the response
	            return ResponseEntity.ok(savedProduct);
	        } catch (ProductNotFoundException ex) {
	            // If the product with the specified SKU is not found, return a 404 Not Found response
	            return ResponseEntity.notFound().build();
	        }
	    }
}

