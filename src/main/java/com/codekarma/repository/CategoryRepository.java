package com.codekarma.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codekarma.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE name = :name")
	Category getCategoryByName(@Param("name") String name);

}
