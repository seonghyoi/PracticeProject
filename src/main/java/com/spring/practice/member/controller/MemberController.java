package com.spring.practice.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.practice.member.model.dto.MemberDTO;
import com.spring.practice.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	//--------------------------------------------------------- // @Autowired 생략 가능
	 public MemberController(MemberService memberService) {
		 this.memberService = memberService; 
	 }
	
	 
	 @RequestMapping("/enrollForm")
	 public String enrollForm() {
		 return "member/enroll_form";
	 }
	 
	 @PostMapping("/insertMember")
	 public String insertMember(MemberDTO memberDTO, HttpSession session) throws Exception {
		 
		 System.out.println("회원 가입 정보: " + memberDTO);
			
		 memberService.insertMember(memberDTO);

		 session.setAttribute("msg", "회원 가입 성공!");
			
		 return "redirect:/";
		 
	 }
	
	
	
	
}
