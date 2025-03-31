package org.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.techhub.entity.Category;
import org.techhub.exception.CategoryNotFoundException;
import org.techhub.repositry.CatergoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CatergoryRepository catergoryRepository;

    public Page<Category> getCategories(Pageable pageable) {
        return catergoryRepository.findAll(pageable);
    }

    public Category createCategory(Category category) {
        return catergoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return catergoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + id));
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = catergoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + id));
        category.setC_name(categoryDetails.getC_name());
        // Update additional fields as necessary
        return catergoryRepository.save(category);
    }

    public String deleteCategory(Long id) {
        if (!catergoryRepository.existsById(id)) {
           return "Data not found with provided Id";
        }
        catergoryRepository.deleteById(id);
        return "Delete Successfully";
    }
}
