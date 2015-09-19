package com.codekarma.service;
import java.util.List;

import com.codekarma.domain.Member;
import com.codekarma.domain.Role;

public interface MemberService {
	public void add(Member member);
	public void edit(Member member);
	public void delete(int memberId);
	public Member getMember(int memberId);
	public List<Member> getAllMember();
	public Member validateMember(Member member);
	public boolean checkUsername(String username);
	public String encryptPass(String password);
	public boolean checkPassword(String password, String encodedPassword);
	public List<Member> getMemberByName(String name);
}
