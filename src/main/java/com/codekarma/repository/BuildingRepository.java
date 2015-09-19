package com.codekarma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codekarma.domain.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer>{
	@Query("SELECT b FROM Building b WHERE b.name = :name")
	Building findByBuildingName(@Param("name") String name);
}
