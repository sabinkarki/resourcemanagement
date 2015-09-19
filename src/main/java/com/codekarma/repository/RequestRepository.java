package com.codekarma.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codekarma.domain.ResourceRequest;

public interface RequestRepository extends CrudRepository<ResourceRequest, Integer>{

	@Query("SELECT r FROM ResourceRequest r WHERE r.item.id = :item_id")
	ResourceRequest findByItemId(@Param("item_id") Long itemId);

}
