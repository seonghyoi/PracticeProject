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
	 
	 
	 @RequestMapping("/main")
	public String main() {
		 return "redirect:/index.jsp";
	}

	
	 // 회원가입 폼을 불러옴
	 @RequestMapping("/enrollForm")
	 public void enrollForm() {
		 
	 }
	 
	 // 회원가입
	 @PostMapping("/insertMember")
	 public String insertMember(MemberDTO memberDTO, HttpSession session) throws Exception {
		 
		 System.out.println("회원 가입 정보: " + memberDTO);
			
		 memberService.insertMember(memberDTO);

		 session.setAttribute("msg", "회원 가입 성공! 다시 로그인해 주세요.");
			
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
	 public String logoutMember(SessionStatus status) {
			
		 // 현재 @SessionAttributes에 의해 자동으로 저장된 오브젝트를 제거
		 status.setComplete();
			
		 return "redirect:/";
		
	 }
	 
	 
	// 마이페이지를 불러옴
	@RequestMapping("/myPage")
	public void myPage(Model model) {
		 
	}
	 
	// 업데이트 폼을 불러옴
	@RequestMapping("/updateForm")
	public void updateForm() {
			 
	}
	
	// 회원 정보 업데이트 
	@PostMapping("/updateMember")
	public String updateMember(MemberDTO memberDTO, Model model, HttpSession session) {
		
		System.out.println("수정할 회원 정보: " + memberDTO);

		int userId = memberDTO.getUserId();
		
		try {
			
			memberService.updateMember(memberDTO);
			
			MemberDTO loginUser = memberService.selectMember(userId);
			
			model.addAttribute("loginUser", loginUser);
			
			session.setAttribute("msg", "회원 정보 수정 성공!");
			
			return "redirect:/member/myPage";
			
		} catch (Exception e) {

			e.printStackTrace();
			
			model.addAttribute("msg", "회원 정보 수정 실패..");
			
			return "common/errorPage";
			
		}
		
	}
	
	
	// 비밀번호 업데이트 폼을 불러옴
	@RequestMapping("/passwordUpdateForm")
	public void passwordUpdateForm() {
				 
	}

	
	// 비밀번호 업데이트
	@PostMapping("/passwordUpdate")
	public String passwordUpdate(MemberDTO memberDTO, Model model, HttpSession session) {
				 
		System.out.println("수정할 비밀번호 정보: " + memberDTO);
		
		int userId = memberDTO.getUserId();
		
		try {
			
			memberService.updatePassword(memberDTO);
			
			MemberDTO loginUser = memberService.selectMember(userId);
			
			model.addAttribute("loginUser", loginUser);
			
			session.setAttribute("msg", "비밀번호 수정 성공!");
			
			return "redirect:/member/myPage";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			model.addAttribute("msg", "비밀번호 수정 실패..");
			
			return "common/errorPage";
			
		}
			
	}
	
	// 비밀번호 업데이트 폼을 불러옴
	@RequestMapping("/deleteForm")
	public void deleteForm() {
				 
	}
	
	@PostMapping("/deleteMember")
	public String deleteMember(int userId, String pw, HttpSession session) {
		
		int result = 0;
		
		try {
			
			result = memberService.deleteMember(userId, pw);
			
			if(result == 1) {
				
				session.setAttribute("msg", "회원 탈퇴 성공!");
				
				return "redirect:/member/logout";
				
			} else {
				
				session.setAttribute("msg", "회원 탈퇴 실패.. 비밀번호가 일치하지 않습니다.");
				
				return "redirect:/member/deleteForm";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			session.setAttribute("msg", "회원 탈퇴 실패..");
			
			return "redirect:/member/myPage";
			
		}
		
	}
	
	
}
