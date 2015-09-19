package com.codekarma.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codekarma.domain.Member;
import com.codekarma.domain.Response;
import com.codekarma.domain.Role;
import com.codekarma.domain.Member;
import com.codekarma.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Member> memberList = memberService.getAllMember();
		model.addAttribute("memberList", memberList);
		return "member/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("userform") Member member) {
		return "member/register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("userform") Member member, BindingResult result,
			Model model, HttpServletRequest request) throws IllegalStateException, IOException  {

		if (result.hasErrors()) {
			return "member/register";
		}
		if (member.getPassword().equals(member.getRetype())) {
			if (!memberService.checkUsername(member.getUsername())) {
				member.setPassword(memberService.encryptPass(member.getPassword()));
				// User Image
				MultipartFile memberImage = member.getImage();
				if (memberImage != null && !memberImage.isEmpty()) {
					String rootDictory = request.getSession().getServletContext().getRealPath("/");
					String imageSaveName = String.valueOf(member.getUsername()) + memberImage.getOriginalFilename();
					member.setImageUrl( imageSaveName );
					memberImage.transferTo(new File(rootDictory+ "resources\\memberImages\\"+imageSaveName));
				}
				
				memberService.add(member);
				return "redirect:/member";
			} else {
				model.addAttribute("errMessage", "Try Again!! User Already exist!");
			}

		} else {
			model.addAttribute("errMessage", "Try Again!! Password and retype password not matched!");
		}

		return "member/register";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int memberId, ModelMap model) {

		Member member = memberService.getMember(memberId);
		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
		model.addAttribute("member", member);
		return "member/edit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable("id") int memberId, @Valid @ModelAttribute Member member, BindingResult result,
			ModelMap model, HttpServletRequest request) throws IllegalStateException, IOException  {

		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
//		if(result.hasFieldErrors("password")) res
		if (result.hasErrors()) {
			return "member/edit";
		}
		if (member.getEnablePasswordChange() != null) {
			if (member.getPassword().equals(member.getRetype())) {
					member.setPassword(memberService.encryptPass(member.getPassword()));
			} else {
				model.addAttribute("errMessage", "Try Again!! Password and retype password not matched!");
			}
		}else
		{
			Member oldmember = memberService.getMember(memberId);
			member.setPassword(oldmember.getPassword());
			
		}
		// User Image
		MultipartFile memberImage = member.getImage();
		if (memberImage != null && !memberImage.isEmpty()) {
			String rootDictory = request.getSession().getServletContext().getRealPath("/");
			String imageSaveName = String.valueOf(member.getUsername()) + memberImage.getOriginalFilename();
			member.setImageUrl( imageSaveName );
			memberImage.transferTo(new File(rootDictory+ "resources\\memberImages\\"+imageSaveName));
		}else
		{
			Member memberOld = memberService.getMember(memberId);
			member.setImageUrl(memberOld.getImageUrl());
			
		}
		memberService.add(member);
		return "redirect:/member";
		

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Response delete(@PathVariable int id) throws RuntimeException
	{
		memberService.delete(id);
		Response response = new Response();
		response.setMessage("Record successfully deleted.");
		response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value = { "/search/","/search" }, method = RequestMethod.GET)
	public List<Member> search(@RequestParam("searchname") String searchname, HttpServletRequest request, Model model) {
//		return ("hhhhhhhhhhhhhhhhh"+request.getParameter("searchname")+"::::"+searchname);
		//List<Member> memberList = memberService.getMemberByName(searchname);
		List<Member> memberList = memberService.getAllMember();
		
		model.addAttribute("memberList", memberList);
		return memberList;
	}

}
