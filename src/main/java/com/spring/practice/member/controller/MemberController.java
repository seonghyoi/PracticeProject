package com.spring.practice.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.practice.member.model.dto.MemberDTO;
import com.spring.practice.member.service.MemberService;

@Controller
@SessionAttributes("loginUser")
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	//--------------------------------------------------------- // @Autowired 생략 가능
	 public MemberController(MemberService memberService) {
		 this.memberService = memberService; 
	 }
	
	 // 회원가입 폼을 불러옴
	 @RequestMapping("/enrollForm")
	 public String enrollForm() {
		 return "member/enroll_form";
	 }
	 
	 // 회원가입
	 @PostMapping("/insertMember")
	 public String insertMember(MemberDTO memberDTO, HttpSession session) throws Exception {
		 
		 System.out.println("회원 가입 정보: " + memberDTO);
			
		 memberService.insertMember(memberDTO);

		 session.setAttribute("msg", "회원 가입 성공!");
			
		 return "redirect:/";
		 
	 }
	 
	 // 로그인
	 @PostMapping("/login")
	 public String loginMember(MemberDTO memberDTO, Model model) {
		 
		 System.out.println("로그인 정보: " + memberDTO);
		 
		 try {
				
				MemberDTO loginUser = memberService.loginMember(memberDTO);
				
				model.addAttribute("loginUser", loginUser);
				
				return "redirect:/";
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				model.addAttribute("msg", "로그인 실패..");
				
				return "common/errorPage";
				
			}
		 
		 
	 }
	 
	 // 로그아웃
	 @RequestMapping("/logout")
	 public String logout(SessionStatus status) {
			
		 // 현재 @SessionAttributes에 의해 자동으로 저장된 오브젝트를 제거
		 status.setComplete();
			
		 return "redirect:/";
		
		}
	 
	 
	
	
	
	
}
