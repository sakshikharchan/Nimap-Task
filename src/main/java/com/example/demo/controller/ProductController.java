


package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(" Product added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setP_name(updatedProduct.getP_name());
            product.setP_price(updatedProduct.getP_price());
            product.setCategory(updatedProduct.getCategory());
            productRepository.save(product);
            return new ResponseEntity<>(" Product updated successfully", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("❌ Product not found", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(" Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("❌ Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
