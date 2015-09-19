package com.codekarma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codekarma.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer>{

	@Query("SELECT b FROM Room b WHERE b.name = :name")
	Room findByRoomName(@Param("name") String name);
}
