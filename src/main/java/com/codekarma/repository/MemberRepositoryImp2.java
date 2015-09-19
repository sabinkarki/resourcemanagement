package com.codekarma.repository;
import java.util.List;import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codekarma.domain.Member;

@Repository
public interface MemberRepositoryImp2 extends CrudRepository<Member, Integer> {

	@Query("select m from Member m where m.username = :username")
	Member getMemberByUsername(@Param("username") String username);

	@Query("select m from Member m where id = :memberId")
	Member getMemberById(@Param("memberId")int memberId);
	
	@Query("select m from Member m where username = :name")
	List<Member> getMemberByName(@Param("name") String name);
	
	
}
