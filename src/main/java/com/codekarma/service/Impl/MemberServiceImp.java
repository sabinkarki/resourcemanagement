package com.codekarma.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekarma.domain.Member;
import com.codekarma.domain.Role;
import com.codekarma.repository.MemberRepositoryImp2;
import com.codekarma.repository.RoleRopository2;
import com.codekarma.service.MemberService;

@Service
@Transactional
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberRepositoryImp2 memberRepository;
	@Autowired
	RoleRopository2 roleRepository;
	
	@PreAuthorize(value="hasRole('ADMIN')")
	public void add(Member member) {
		
		Role role = roleRepository.getRoleByName("guest");
		member.setRole(role);
		memberRepository.save(member);

	}
	@PreAuthorize(value="hasRole('ADMIN','USER')")
	public void edit(Member member) {
		// TODO Auto-generated method stub

	}
	@PreAuthorize(value="hasRole('ADMIN')")
	public void delete(int memberId) {
		memberRepository.delete(memberId);

	}
	@PreAuthorize(value="hasRole('ADMIN')")
	public Member getMember(int memberId) {
		return (Member)memberRepository.findOne(memberId);//.getMemberById(memberId);
	}

	@PreAuthorize(value="hasRole('ADMIN')")
	public List<Member> getAllMember() {
		return (List<Member>)memberRepository.findAll();
	}

	public boolean checkUsername(String username) 
	{
		return (memberRepository.getMemberByUsername(username)!=null);
	
	}
	
	public String encryptPass(String password) {
		BCryptPasswordEncoder pass1 = new BCryptPasswordEncoder();
		return pass1.encode(password);
	}

	public boolean checkPassword(String password, String encodedPassword) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder.matches(password, encodedPassword);
	}

	@Override
	public Member validateMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Member> getMemberByName(String name) {
	return memberRepository.getMemberByName(name);
	}

}
