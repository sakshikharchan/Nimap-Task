package org.techhub.repositry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.techhub.entity.Category;

public interface CatergoryRepository extends JpaRepository<Category, Long>{
	
	Page<Category> findAll(Pageable pageable);

}
