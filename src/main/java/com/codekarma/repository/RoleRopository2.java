package com.codekarma.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codekarma.domain.Role;

@Repository
public interface RoleRopository2 extends CrudRepository<Role, Integer>
{
	@Query ("select r from Role r where name=:name")
	public Role getRoleByName( @Param("name") String name);

}
