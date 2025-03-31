package org.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.techhub.entity.Product;
import org.techhub.exception.ProductNotFoundException;
import org.techhub.repositry.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public String deleteById(Long id) {
        if (!productRepository.existsById(id)) {
            return "Data not found with provided id";
        }
        productRepository.deleteById(id);
        return "delete successfully";
    }
}
