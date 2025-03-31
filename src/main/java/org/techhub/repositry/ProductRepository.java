package org.techhub.repositry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.techhub.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findAll(Pageable pageable);
	
}
