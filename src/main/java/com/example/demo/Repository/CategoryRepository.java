package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Page<Category> findAll(Pageable pageable);

}
