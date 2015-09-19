package com.codekarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codekarma.domain.Item;

@Repository
public interface ItemsRepository extends CrudRepository<Item, Long>{


}
